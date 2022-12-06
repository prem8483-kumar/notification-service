package com.meesho.notification.requests.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SMSRequestBody {

    @NonNull
    @JsonProperty("phoneNumber")
    String phoneNumber;

    @JsonProperty("message")
    String message;

}
