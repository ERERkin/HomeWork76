package kg.ItAcademy.HomeWork76.services.impls;

import kg.ItAcademy.HomeWork76.enttities.Client;
import kg.ItAcademy.HomeWork76.repos.ClientRepo;
import kg.ItAcademy.HomeWork76.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepo clientRepo;

    @Override
    public Client getById(Long id) {
        Optional<Client> optionalPayment = clientRepo.findById(id);
        return optionalPayment.get();
    }

    @Override
    public List<Client> getAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client save(Client item) {
        return clientRepo.save(item);
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepo.findAllByName(name);
    }
}
