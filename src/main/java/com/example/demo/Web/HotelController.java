package com.example.demo.Web;

import com.example.demo.Model.Hotel;
import com.example.demo.Service.Implementation.HotelServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final com.example.demo.Service.Implementation.HotelServiceImplementation hotelServiceImplementation;

    public HotelController(HotelServiceImplementation hotelServiceImplementation) {
        this.hotelServiceImplementation = hotelServiceImplementation;
    }


    @GetMapping
    public String getHotelPage(Model model){
        List<Hotel> hotels= hotelServiceImplementation.findAll();
        model.addAttribute("hotels",hotels);
        return "/hotel";
    }
    @GetMapping("/addHotel")
    public String addHotelPage(Model model){
        return "/add-hotel";
    }
    @PostMapping("/addHotel")
    public String addHotelPost(HttpServletRequest req){
        String name=req.getParameter("imeHotel");
        String noRooms=req.getParameter("Sobi");
        String price=req.getParameter("price");
        String noStars=req.getParameter("numberOfStars");
        Hotel hotel=new Hotel(name,Integer.parseInt(noRooms),Integer.parseInt(price),Integer.parseInt(noStars));
        hotelServiceImplementation.save(hotel);
        return "redirect:/hotels";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelServiceImplementation.delete(id);
        return "redirect:/hotels";
    }
}
