package com.meesho.notification.models.response.blacklist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveNumberFromBlacklistResponse {

    @JsonProperty("data")
    String data;

}
