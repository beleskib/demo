package com.example.demo.Service;

import com.example.demo.Model.Clients;
import java.util.List;
public interface ClientsService {
    public List<Clients> findAll();
    public void save(Clients clients);
    void delete(Long id);

    Clients login(String username, String password);
}
