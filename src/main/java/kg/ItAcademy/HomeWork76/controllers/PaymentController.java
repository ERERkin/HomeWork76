package kg.ItAcademy.HomeWork76.controllers;

import kg.ItAcademy.HomeWork76.enttities.Payment;
import kg.ItAcademy.HomeWork76.enums.Status;
import kg.ItAcademy.HomeWork76.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
