package kg.ItAcademy.HomeWork76.controllers;

import kg.ItAcademy.HomeWork76.enttities.Payment;
import kg.ItAcademy.HomeWork76.enums.Status;
import kg.ItAcademy.HomeWork76.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentService.getById(id);
    }

    @GetMapping("/getByStatus/{status}")
    public List<Payment> getByStatus(@PathVariable("status") Status status) {
        return paymentService.getByStatus(status);
    }

    @GetMapping("/getByClientId/{clientId}")
    public List<Payment> getByClientId(@PathVariable("clientId") Long clientId) {
        return paymentService.getByClientId(clientId);
    }

    @GetMapping("/getByClientIdNative/{clientId}")
    public List<Payment> getByClientIdNative(@PathVariable("clientId") Long clientId) {
        return paymentService.getByClientIdNative(clientId);
    }

    @GetMapping("/getByDateAndClient/{createDateStarted}&{createDateEnd}&{clientId}")
    List<Payment> findAllByCreatedDatePeriodAndClientQuery(
            @PathVariable("createDateStarted") String createDateStarted,
            @PathVariable("createDateEnd") String createDateEnd,
            @PathVariable("clientId") Long clientId) throws ParseException {
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        Date date1 =formatter.parse(createDateStarted);
        Date date2 =formatter.parse(createDateEnd);
        //return "hi" + " " + date1 + " " + date2;
        return paymentService.findAllByCreatedDatePeriodAndClientQuery(
                date1,
                date2,
                clientId
        );
    }
}
