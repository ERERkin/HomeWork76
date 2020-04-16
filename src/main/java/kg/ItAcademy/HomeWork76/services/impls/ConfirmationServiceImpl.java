package kg.ItAcademy.HomeWork76.services.impls;

import kg.ItAcademy.HomeWork76.enttities.Account;
import kg.ItAcademy.HomeWork76.enttities.Confirmation;
import kg.ItAcademy.HomeWork76.enttities.Payment;
import kg.ItAcademy.HomeWork76.enums.Status;
import kg.ItAcademy.HomeWork76.repos.ConfirmationRepo;
import kg.ItAcademy.HomeWork76.services.AccountService;
import kg.ItAcademy.HomeWork76.services.ClientService;
import kg.ItAcademy.HomeWork76.services.ConfirmationService;
import kg.ItAcademy.HomeWork76.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ConfirmationServiceImpl implements ConfirmationService {
    @Autowired
    private ConfirmationRepo confirmationRepo;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AccountService accountService;

    @Override
    public Confirmation getById(Long id) {
        Optional<Confirmation> confirmation = confirmationRepo.findById(id);
        return null;
    }

    @Override
    public List<Confirmation> getAll() {
        return confirmationRepo.findAll();
    }

    @Override
    public Confirmation save(Confirmation item) {
        Payment payment = paymentService.getById(item.getPayment().getId());
        payment.setStatus(payment.getCode() == item.getAnswerCode() ? Status.SUCCESS : Status.FAILED);
        item.setClient(clientService.getById(item.getClient().getId()));
        if (payment.getStatus().equals(Status.SUCCESS)) {
            //Get money from
            Account from = accountService.getById(payment.getAccountFrom().getId());
            from.setBalance(from.getBalance().subtract(payment.getAmount()));
            Account to = accountService.getById(payment.getAccountTo().getId());
            to.setBalance(to.getBalance().add(payment.getAmount()));
            accountService.save(from);
            accountService.save(to);
            payment.setAccountFrom(from);
            payment.setAccountTo(to);
            //Put money to
        }
        item.setPayment(payment);
        paymentService.save(payment);
        return confirmationRepo.save(item);
    }
}
