package com.example.demo.Service.Implementation;

import com.example.demo.Model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.KorisnikRepository;
import com.example.demo.Model.Exception.InvalidArgumentException;
import com.example.demo.Model.Role;
import com.example.demo.Repository.KorisnikRepository;
import com.example.demo.Service.KorisnikService;
@Service
public class KorisnikServiceImplementacija implements KorisnikService {
    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;
    public KorisnikServiceImplementacija(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Korisnik login(String username, String password) {

        return korisnikRepository.findByUsernameAndPassword(username,
                password).orElseThrow();

    }

    @Override
    public Korisnik register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword))
            throw new InvalidArgumentException();
        if (this.korisnikRepository.findByUsername(username).isPresent()
                || !this.korisnikRepository.findByUsername(username).isEmpty()){
            throw new InvalidArgumentException();
        }
        Korisnik korisnik = new Korisnik(username, passwordEncoder.encode(password), name, surname, role);
        return korisnikRepository.save(korisnik);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return korisnikRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException(s));
    }
}

