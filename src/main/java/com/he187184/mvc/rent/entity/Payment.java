package com.he187184.mvc.rent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum PaymentType {
        CASH, CARD, TRANSFER
    }

    public enum Status {
        SUCCESS, FAILED, PENDING
    }
}
