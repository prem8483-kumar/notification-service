package com.meesho.notification.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SMSRequest {

    @NonNull
    @JsonProperty("phoneNumber")
    String phoneNumber;

    @JsonProperty("message")
    String message;

}
