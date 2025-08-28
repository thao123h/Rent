package com.he187184.mvc.rent.service;

import com.he187184.mvc.rent.dto.BookingDTO;
import com.he187184.mvc.rent.entity.Booking;
import com.he187184.mvc.rent.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    @Autowired
    BookingRepository bookingRepository;


    Booking createBooking (Booking booking){

    }
}
