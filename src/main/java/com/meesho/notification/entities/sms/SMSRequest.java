package com.meesho.notification.entities.sms;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="sms_requests")
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
}
