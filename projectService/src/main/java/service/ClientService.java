package service;

import model.Client;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface ClientService {

    boolean existsById(UUID id);

    Client findById(UUID id);

    List<Client> findAll();

    @Transactional
    void deleteById(UUID id);

    @Transactional
    Client save(Client client);
}
