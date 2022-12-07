package com.meesho.notification.services.blacklist;

import com.meesho.notification.models.requests.blacklist.BlacklistRequestBody;
import com.meesho.notification.models.response.blacklist.AddNumberToBlacklistResponse;
import com.meesho.notification.models.response.blacklist.GetBlacklistedNumbersResponse;
import com.meesho.notification.models.response.blacklist.RemoveNumberFromBlacklistResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlacklistServiceImpl implements BlacklistService{

    @Override
    public AddNumberToBlacklistResponse addNumbersToBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequestBody.toString());
        return AddNumberToBlacklistResponse.builder().data("Successfully blacklisted").build();

    }

    @Override
    public GetBlacklistedNumbersResponse getBlacklistedNumbers() {
        log.info("Get Blacklists Number List");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("+918483974081");
        return GetBlacklistedNumbersResponse.builder().data(phoneNumbers).build();

    }

    @Override
    public RemoveNumberFromBlacklistResponse removeNumbersFromBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequestBody.toString());
        return RemoveNumberFromBlacklistResponse.builder().data("Successfully whitelisted").build();
    }
}
