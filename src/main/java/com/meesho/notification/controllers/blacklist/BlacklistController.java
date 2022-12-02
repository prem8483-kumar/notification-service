package com.meesho.notification.controllers.blacklist;


import com.meesho.notification.models.blacklist.BlacklistRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BlacklistController {

    @PostMapping(path = "/v1/blacklist")
    public void addNumbersToBlacklist(@RequestBody BlacklistRequest blacklistRequest) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequest.toString());
    }

    @GetMapping(path = "/v1/blacklist")
    public void getBlacklistedNumbers() {

        log.info("Get Blacklists Number List");
    }

    @DeleteMapping(path = "/v1/blacklist")
    public void removeNumbersFromBlacklist(@RequestBody BlacklistRequest blacklistRequest) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequest.toString());
    }

}
