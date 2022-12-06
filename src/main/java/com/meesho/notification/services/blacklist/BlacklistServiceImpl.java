package com.meesho.notification.services.blacklist;

import com.meesho.notification.requests.blacklist.BlacklistRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlacklistServiceImpl implements BlacklistService{

    @Override
    public void addNumbersToBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequestBody.toString());


    }

    @Override
    public void getBlacklistedNumbers() {
        log.info("Get Blacklists Number List");

    }

    @Override
    public void removeNumbersFromBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequestBody.toString());

    }
}
