package com.meesho.notification.models.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseError {

    @JsonProperty("error")
    ErrorData error;

}
