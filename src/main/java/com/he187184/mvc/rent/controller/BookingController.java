package com.he187184.mvc.rent.controller;

import com.he187184.mvc.rent.dto.BookingDTO;
import com.he187184.mvc.rent.entity.Booking;
import com.he187184.mvc.rent.mapper.BookingMapper;
import com.he187184.mvc.rent.repository.BookingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    BookingMapper bookingMapper;

    @PostMapping("/create")
    public BookingDTO createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking
        bookingRepository.save(booking);

        return bookingMapper.toDTO(booking);

    }
}

