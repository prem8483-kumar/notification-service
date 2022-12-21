package com.meesho.notification.utils.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meesho.notification.constants.KafkaConstants;
import com.meesho.notification.constants.RedisConstants;
import com.meesho.notification.helpers.IndexHelper;
import com.meesho.notification.models.entities.sms.SMSRequest;
import com.meesho.notification.repositories.sms.SMSRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    SMSRequestRepository smsRequestRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private IndexHelper indexHelper;

    @Value(RedisConstants.BLACKLISTED_NUMBERS_KEY)
    private String blacklistedNumbersKey;


    @KafkaListener(topics = KafkaConstants.SEND_SMS_TOPIC, groupId = KafkaConstants.SEND_SMS_CONSUMER_GROUP_ID)
    public void consumeMessage(String message) {
        log.info("Received message: " + message);

        log.info("Get the request details from db");
        SMSRequest smsRequest =  smsRequestRepository.findById(Integer.valueOf(message)).get();

        log.info("Check if number is blacklisted via redis");
        if(Objects.requireNonNull(redisTemplate.opsForSet().isMember(blacklistedNumbersKey, smsRequest.getPhoneNumber()))) {
            log.info("Number is blacklisted via redis");

            log.info("Update the status, message_id, failure_details if any in DB");
            smsRequest.setStatus("FAILURE");
            smsRequest.setFailureCode("NUMBER_BLOCKED");
            smsRequest.setFailureComments("Phone Number is blacklisted");
            smsRequest = smsRequestRepository.save(smsRequest);

            return;
        }

        log.info("Call the 3rd party api to send sms");

        log.info("Update the status, message_id, failure_details if any in DB");
        smsRequest.setStatus("SUCCESS");
        smsRequest = smsRequestRepository.save(smsRequest);

        log.info("Index the sms details in elastic search");
        indexHelper.indexSMSDetailsData(smsRequest);
    }

}
