package kg.ItAcademy.HomeWork76.controllers;

import kg.ItAcademy.HomeWork76.enttities.Confirmation;
import kg.ItAcademy.HomeWork76.services.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm")
public class ConfirmationController {
    @Autowired
    ConfirmationService confirmationService;

    @PostMapping
    public Confirmation save(@RequestBody Confirmation confirmation){
        return confirmationService.save(confirmation);
    }
}
