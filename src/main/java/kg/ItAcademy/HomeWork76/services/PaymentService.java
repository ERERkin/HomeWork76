package kg.ItAcademy.HomeWork76.services;


import kg.ItAcademy.HomeWork76.enttities.Payment;
import kg.ItAcademy.HomeWork76.enums.Status;

import java.util.Date;
import java.util.List;

public interface PaymentService extends BaseService<Payment> {
    Payment createPayment(Payment payment);

    List<Payment> getByStatus(Status status);

    List<Payment> getByClientId(Long clientId);

    List<Payment> getByClientIdNative(Long clientId);

    List<Payment> findAllByCreatedDateBetweenAndByAccountFrom_Client_Id(
            Date createDateStarted,
            Date createDateEnd,
            Long clientId);
}
