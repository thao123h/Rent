package com.he187184.mvc.rent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "chat_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ChatConversation conversation;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "message_type")
    private MessageType messageType;

    @Column(name = "attachment_url")
    private String attachmentUrl;

    @Column(name = "is_read")
    private Boolean isRead;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum MessageType {
        TEXT, IMAGE, FILE
    }
}
