package kg.ItAcademy.HomeWork76.controllers;

import kg.ItAcademy.HomeWork76.enttities.Client;
import kg.ItAcademy.HomeWork76.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    public Client save(@RequestBody Client payment) {
        return clientService.save(payment);
    }
    
    @GetMapping("/{id}")
    public Client getById(@PathVariable("id") Long id) {
        return clientService.getById(id);
    }
}
