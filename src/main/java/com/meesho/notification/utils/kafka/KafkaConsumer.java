package com.meesho.notification.utils.kafka;

import com.meesho.notification.models.entities.sms.SMSRequest;
import com.meesho.notification.repositories.sms.SMSRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private static final String SEND_SMS_TOPIC = "notification.send_sms";
    private static final String SEND_SMS_CONSUMER_GROUP_ID = "notification.send_sms_consumer_group_id";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    SMSRequestRepository smsRequestRepository;

    @KafkaListener(topics = SEND_SMS_TOPIC, groupId = SEND_SMS_CONSUMER_GROUP_ID)
    public void consumeMessage(String message) {
        log.info("Received message on topic " + SEND_SMS_TOPIC + ": " + message);

        log.info("Get the request details from db");
        SMSRequest smsRequest =  smsRequestRepository.findById(Integer.valueOf(message)).get();

        log.info("Check if number is blacklisted via redis");

        log.info("Call the 3rd party api to send sms");

        log.info("Update the status, message_id, failure_details if any in DB");
        smsRequest.setStatus("SUCCESS");
        smsRequest = smsRequestRepository.save(smsRequest);

        log.info("Index the details in elastic search");

    }

}