package com.he187184.mvc.rent.dto;

import ch.qos.logback.core.status.Status;
import com.he187184.mvc.rent.entity.Booking;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BookingDTO {

    @NotNull(message = "Item is required")
    private Integer itemId;

    @NotNull(message = "Renter is required")
    private Integer renterId;
    @NotNull(message = "wner is required")
    private Integer ownerId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
    @NotNull(message = "Rental hours is required")
    @Min(value = 1, message = "Rental hours must be at least 1")
    private Integer rentalHours;

    @NotNull(message = "Deposit amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Deposit must be greater than 0")
    private Double depositAmount;
    private String notes;

    private Status status;

    private Booking.PaymentStatus paymentStatus;

    private String cancellationReason;
}
