package kg.ItAcademy.HomeWork76.services.impls;

import kg.ItAcademy.HomeWork76.enttities.Payment;
import kg.ItAcademy.HomeWork76.enums.Status;
import kg.ItAcademy.HomeWork76.repos.PaymentRepo;
import kg.ItAcademy.HomeWork76.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment getById(Long id) {
        Optional<Payment> optionalPayment = paymentRepo.findById(id);
        return optionalPayment.get();
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment save(Payment item) {
        return paymentRepo.save(item);
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setStatus(Status.PROCESS);
        payment.setCode(generateCode());
        return save(payment);
    }

    private Integer generateCode(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    @Override
    public List<Payment> findAllByCreatedDatePeriodAndClientQuery(
            Date createDateStarted,
            Date createDateEnd,
            Long clientId
    ){
        return paymentRepo.findAllByCreatedDatePeriodAndClientQuery(
                createDateStarted,
                createDateEnd,
                clientId
        );
    };

    @Override
    public List<Payment> getByStatus(Status status) {
        return paymentRepo.findAllByStatusQuery(status);
    }

    @Override
    public List<Payment> getByClientId(Long clientId) {
        return paymentRepo.findAllByAccountFrom_Client_Id(clientId);
    }

    @Override
    public List<Payment> getByClientIdNative(Long clientId) {
        return paymentRepo.findAllByClientId(clientId);
    }

}
