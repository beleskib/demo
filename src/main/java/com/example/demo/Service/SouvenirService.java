package com.example.demo.Service;

import com.example.demo.Model.Souvenir;
import com.example.demo.Model.Clients;
import java.util.List;

public interface SouvenirService {
    public List<Souvenir> findAll();
    public void save(Souvenir souvenir);
    void delete(Long id);

}