package com.he187184.mvc.rent.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewed_id")
    private User reviewed;

    private Integer rating;
    private String review;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
