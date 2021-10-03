package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Korisnik;
import java.util.Optional;
@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
    Optional<Korisnik> findByUsernameAndPassword(String username, String password);
    Optional<Korisnik> findByUsername(String username);

}