package com.meesho.notification.utils.kafka;

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

    public KafkaConsumer() {

    }


    @KafkaListener(topics = SEND_SMS_TOPIC, groupId = SEND_SMS_CONSUMER_GROUP_ID)
    public void consumeMessage(String message) {
        log.info("Received message on topic: " + SEND_SMS_TOPIC + "\n" + message  );
    }

}
