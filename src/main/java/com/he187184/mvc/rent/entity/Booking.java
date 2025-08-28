

package com.he187184.mvc.rent.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private User renter;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "rental_hours")
    private Integer rentalHours;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "damage_fee")
    private Double damageFee;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    private String notes;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Payment> payments;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
    private ChatConversation chatConversation;


    public enum Status {
        PENDING, CONFIRMED, CANCELLED, COMPLETED;

        @JsonValue
        public String toLower() {
            return this.name().toLowerCase(); // serialize thành chữ thường
        }

        @JsonCreator
        public static Status fromString(String value) {
            return Status.valueOf(value.toUpperCase()); // deserialize chữ thường thành enum
        }
    }

    public enum PaymentStatus {
        UNPAID, PAID;

        @JsonValue
        public String toLower() {
            return this.name().toLowerCase();
        }

        @JsonCreator
        public static PaymentStatus fromString(String value) {
            return PaymentStatus.valueOf(value.toUpperCase());
        }
    }
}
