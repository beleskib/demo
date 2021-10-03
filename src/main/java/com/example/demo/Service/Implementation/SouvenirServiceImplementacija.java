package com.example.demo.Service.Implementation;
import com.example.demo.Model.Souvenir;
import com.example.demo.Repository.SouvenirRepository;
import com.example.demo.Service.SouvenirService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SouvenirServiceImplementacija implements SouvenirService {
    private final SouvenirRepository souvenirRepository;

    public SouvenirServiceImplementacija(SouvenirRepository souvenirRepository) {
        this.souvenirRepository = souvenirRepository;
    }


    public List<Souvenir> findAll() {
        return souvenirRepository.findAll();
    }

    @Override
    public void save(Souvenir souvenir) {
        souvenirRepository.save(souvenir);
    }

    @Override
    public void delete(Long id) {
        Souvenir souvenir = souvenirRepository.findById(id).get();
        souvenirRepository.delete(souvenir);
    }
}
