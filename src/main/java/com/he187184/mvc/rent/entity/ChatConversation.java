package com.he187184.mvc.rent.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity

@Table(name = "chat_conversations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "participant1_id")
    private User participant1;

    @ManyToOne
    @JoinColumn(name = "participant2_id")
    private User participant2;

    @Column(name = "last_message_at")
    private LocalDateTime lastMessageAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "conversation")
    private List<ChatMessage> messages;
}
