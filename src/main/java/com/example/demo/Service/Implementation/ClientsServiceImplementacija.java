package com.example.demo.Service.Implementation;


import com.example.demo.Model.Clients;
import com.example.demo.Repository.ClientsRepository;
import com.example.demo.Service.ClientsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class ClientsServiceImplementacija implements ClientsService {
    private final ClientsRepository clientsRepository;

    public ClientsServiceImplementacija(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> findAll() {
        return clientsRepository.findAll();
    }

    @Override
    public void save(Clients clients) {
        clientsRepository.save(clients);
    }

    @Override
    public void delete(Long id) {
        Clients clients=clientsRepository.findById(id).get();
        clientsRepository.delete(clients);
    }

    @Override
    public Clients login(String username, String password) {
        return null;
    }
}
