package com.meesho.notification.services.blacklist;

import com.meesho.notification.constants.KafkaConstants;
import com.meesho.notification.constants.RedisConstants;
import com.meesho.notification.models.requests.blacklist.BlacklistRequestBody;
import com.meesho.notification.models.response.blacklist.AddNumberToBlacklistResponse;
import com.meesho.notification.models.response.blacklist.GetBlacklistedNumbersResponse;
import com.meesho.notification.models.response.blacklist.RemoveNumberFromBlacklistResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class BlacklistServiceImpl implements BlacklistService{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value(RedisConstants.BLACKLISTED_NUMBERS_KEY)
    private String blacklistedNumbersKey;


    @Override
    public AddNumberToBlacklistResponse addNumbersToBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Add Number to Blacklist Request: " +  blacklistRequestBody.toString());
        redisTemplate.opsForSet().add(blacklistedNumbersKey, blacklistRequestBody.getPhoneNumbers());
        return AddNumberToBlacklistResponse.builder().data("Successfully blacklisted").build();

    }

    @Override
    public GetBlacklistedNumbersResponse getBlacklistedNumbers() {
        log.info("Get Blacklists Number List");
        Set<Object> phoneNumbers = redisTemplate.opsForSet().members(blacklistedNumbersKey);
        return GetBlacklistedNumbersResponse.builder().data(phoneNumbers).build();
    }

    @Override
    public RemoveNumberFromBlacklistResponse removeNumbersFromBlacklist(BlacklistRequestBody blacklistRequestBody) {
        log.info("Remove Number from Blacklist Request: " + blacklistRequestBody.toString());
        redisTemplate.opsForSet().remove(blacklistedNumbersKey, blacklistRequestBody.getPhoneNumbers());
        return RemoveNumberFromBlacklistResponse.builder().data("Successfully whitelisted").build();
    }
}
