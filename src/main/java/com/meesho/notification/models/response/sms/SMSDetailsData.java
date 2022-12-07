package com.meesho.notification.models.response.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SMSDetailsData {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("phone_number")
    String phoneNumber;

    @JsonProperty("message")
    String message;

    @JsonProperty("status")
    String status;

    @JsonProperty("failure_code")
    String failureCode;

    @JsonProperty("failure_comments")
    String failureComments;

}
