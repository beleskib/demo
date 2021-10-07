package com.example.demo.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.demo.Model.Korisnik;
import com.example.demo.Model.Role;

public interface KorisnikService extends UserDetailsService {


    Korisnik login(String username, String password);

    Korisnik register(String username, String password, String repeatPassword, String name, String surname, Role role);

}