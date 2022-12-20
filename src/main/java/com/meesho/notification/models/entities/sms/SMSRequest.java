package com.meesho.notification.models.entities.sms;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="sms_requests")
@Builder
public class SMSRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "message")
    String message;

    @Column(name = "status")
    String status;

    @Column(name = "failure_code")
    String failureCode;

    @Column(name = "failure_comments")
    String failureComments;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

}
