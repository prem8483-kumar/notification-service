package com.meesho.notification.models.response.blacklist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetBlacklistedNumbersResponse {

    @JsonProperty("data")
    Set<Object> data;

}
