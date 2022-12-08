package com.meesho.notification.controllers.blacklist;


import com.meesho.notification.models.requests.blacklist.BlacklistRequestBody;
import com.meesho.notification.models.response.blacklist.AddNumberToBlacklistResponse;
import com.meesho.notification.models.response.blacklist.GetBlacklistedNumbersResponse;
import com.meesho.notification.models.response.blacklist.RemoveNumberFromBlacklistResponse;
import com.meesho.notification.services.blacklist.BlacklistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BlacklistController {

    @Autowired
    BlacklistService blacklistService;

    @PostMapping(path = "/v1/blacklist")
    public AddNumberToBlacklistResponse addNumbersToBlacklist(@RequestBody BlacklistRequestBody blacklistRequestBody) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequestBody.toString());
        return blacklistService.addNumbersToBlacklist(blacklistRequestBody);
    }

    @GetMapping(path = "/v1/blacklist")
    public GetBlacklistedNumbersResponse getBlacklistedNumbers() {
        log.info("Get Blacklists Number List");
        return blacklistService.getBlacklistedNumbers();
    }

    @DeleteMapping(path = "/v1/blacklist")
    public RemoveNumberFromBlacklistResponse removeNumbersFromBlacklist(@RequestBody BlacklistRequestBody blacklistRequestBody) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequestBody.toString());
        return blacklistService.removeNumbersFromBlacklist(blacklistRequestBody);
    }

}
