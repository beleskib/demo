package com.example.demo.bootstrap;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.example.demo.Model.*;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter

public class DataHolder {
    public static List<Hotel> hotelList = new ArrayList<>();
    public static List<Clients> clientsList = new ArrayList<>();
    public static List<Korisnik> korisnici = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init(){



        Clients client1 = new Clients();
        Clients client2 = new Clients();

        clientsList.add(client1);
        clientsList.add(client2);

        hotelList.add(new Hotel());

        korisnici.add(new Korisnik());

        employeeList.add(new Employee());


    }
}