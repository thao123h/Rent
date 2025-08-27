package com.he187184.mvc.rent.entity;

import com.he187184.mvc.rent.common.Role;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "identity_card")
    private String identityCard;

    private String avatar;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "renter")
    private List<Booking> bookings;

}
