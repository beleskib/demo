package com.example.demo.Service.Implementation;

import com.example.demo.Model.Hotel;
import com.example.demo.Repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImplementation implements com.example.demo.Service.HotelService{
    private final HotelRepository hotelRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotelRepository.delete(hotel);
    }
}
