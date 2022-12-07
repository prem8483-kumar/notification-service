package com.meesho.notification.models.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorData {

    @JsonProperty("code")
    String code;

    @JsonProperty("message")
    String message;

}
