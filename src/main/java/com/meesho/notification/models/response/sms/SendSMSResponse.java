package com.meesho.notification.models.response.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendSMSResponse {

    @JsonProperty("data")
    SendSMSData data;

}
