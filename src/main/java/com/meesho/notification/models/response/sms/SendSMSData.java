package com.meesho.notification.models.response.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendSMSData {

    @JsonProperty("requestId")
    Integer requestId;

    @JsonProperty("comments")
    String comments;

}
