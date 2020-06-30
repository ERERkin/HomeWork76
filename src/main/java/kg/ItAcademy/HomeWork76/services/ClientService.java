package kg.ItAcademy.HomeWork76.services;



import kg.ItAcademy.HomeWork76.enttities.Client;

import java.util.List;

public interface ClientService extends BaseService<Client> {
    List<Client> findByName(String name);
}
