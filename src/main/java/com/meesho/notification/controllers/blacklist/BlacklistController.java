package com.meesho.notification.controllers.blacklist;


import com.meesho.notification.models.requests.blacklist.BlacklistRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BlacklistController {

    @PostMapping(path = "/v1/blacklist")
    public void addNumbersToBlacklist(@RequestBody BlacklistRequestBody blacklistRequestBody) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequestBody.toString());
    }

    @GetMapping(path = "/v1/blacklist")
    public void getBlacklistedNumbers() {

        log.info("Get Blacklists Number List");
    }

    @DeleteMapping(path = "/v1/blacklist")
    public void removeNumbersFromBlacklist(@RequestBody BlacklistRequestBody blacklistRequestBody) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequestBody.toString());
    }

}
