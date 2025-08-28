package com.he187184.mvc.rent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    private String address;
    @Column(name = "condition_rating")
    private int condition_rating;

    @Enumerated(EnumType.STRING)
    private Status availability_status;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<ItemImage> images;

    @OneToMany(mappedBy = "item")
    private List<Booking> bookings;

    public enum Status {
        available, unavailable
    }
}
