package com.he187184.mvc.rent.repository;

import com.he187184.mvc.rent.entity.Booking;
import com.he187184.mvc.rent.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Integer> {
}
