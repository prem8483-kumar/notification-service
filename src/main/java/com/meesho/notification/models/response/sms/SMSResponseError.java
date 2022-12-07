package com.meesho.notification.models.response.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SMSResponseError {

    @JsonProperty("error")
    SMSErrorData error;

}
