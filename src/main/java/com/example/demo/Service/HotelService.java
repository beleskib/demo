package com.example.demo.Service;
import com.example.demo.Model.Hotel;
import java.util.List;

public interface HotelService {
    public List<Hotel> findAll();
    public void save(Hotel hotel);
    void delete(Long id);
}
