package com.meesho.notification.models.blacklist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistRequest {

    @NonNull
    @JsonProperty("phoneNumbers")
    List<String> phoneNumbers;

}
