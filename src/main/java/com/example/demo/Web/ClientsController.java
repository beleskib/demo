package com.example.demo.Web;

import com.example.demo.Model.Clients;
import com.example.demo.Service.Implementation.ClientsServiceImplementacija;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsServiceImplementacija clientsServiceImplementacija;

    public ClientsController(ClientsServiceImplementacija clientsServiceImplementacija) {
        this.clientsServiceImplementacija = clientsServiceImplementacija;
    }
    @GetMapping
    public String getClientsPage(Model model){
        List<Clients> clients = clientsServiceImplementacija.findAll();
        model.addAttribute("clients", clients);
        return "/Clients";
    }
    @GetMapping("/addClients")
    public String addClientsPage(Model model)
    {
        return "/add-clients";
    }
    @PostMapping("/addClients")
    public String addClientsPost(HttpServletRequest req){
        String name= req.getParameter("name");
        String lastname = req.getParameter("lastname");

        Clients clients = new Clients(name, lastname);

        clientsServiceImplementacija.save(clients);
        return "redirect:/clients";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteClients(@PathVariable Long id)
    {
        clientsServiceImplementacija.delete(id);
        return "redirect:/clients";
    }
}
