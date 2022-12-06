package com.meesho.notification.requests.blacklist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistRequestBody {

    @NonNull
    @JsonProperty("phoneNumbers")
    List<String> phoneNumbers;

}