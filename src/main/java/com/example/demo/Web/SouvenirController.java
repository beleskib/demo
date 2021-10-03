package com.example.demo.Web;

import com.example.demo.Model.Souvenir;
import com.example.demo.Service.Implementation.SouvenirServiceImplementacija;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/souvenirs")
public class SouvenirController    {
    private final SouvenirServiceImplementacija souvenirServiceImplementacija;

    public SouvenirController(SouvenirServiceImplementacija souvenirServiceImplementacija) {
        this.souvenirServiceImplementacija = souvenirServiceImplementacija;
    }
    @GetMapping
    public String getSouvenirPage(Model model)
    {
        List<Souvenir> products = souvenirServiceImplementacija.findAll();
        model.addAttribute("products", products);
        return "/Souvenirs";
    }
    @GetMapping("/addSouvenirs")
    public String addSouvenirPage(Model model)
    {
        return "/add-souvenirs";
    }
    @PostMapping("/addSouvenirs")
    public String addSouvenirPost(HttpServletRequest req)
    {
        String name = req.getParameter("souvenir");
        String price = req.getParameter("price");

        Souvenir souvenir = new Souvenir(name, Integer.parseInt(price));
        souvenirServiceImplementacija.save(souvenir);
        return "redirect:/souvenirs";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSouvenir(@PathVariable Long id){
        souvenirServiceImplementacija.delete(id);
        return "redirect:/souvenirs";
    }
    @GetMapping("/edit/{id}")
    public String editSouvenir(@PathVariable Long id,Model model){
        model.addAttribute("id",id);
        return "/edit-souvenirs";
    }
    @PostMapping("/editSouvenirs/{id}")
    public String editSouvenir(HttpServletRequest req,@PathVariable Long id)
    {

        souvenirServiceImplementacija.delete(id);
        String name = req.getParameter("souvenir");
        String price = req.getParameter("price");

        Souvenir souvenir = new Souvenir(name, Integer.parseInt(price));
        souvenirServiceImplementacija.save(souvenir);
        return "redirect:/souvenirs";
    }
}
