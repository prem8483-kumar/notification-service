package com.meesho.notification.utils.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    private static final String SEND_SMS_TOPIC = "notification.send_sms";

    public KafkaProducer() {

    }

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Published message on topic: " + SEND_SMS_TOPIC + "\n" + message  );
        kafkaTemplate.send(SEND_SMS_TOPIC, message);
    }

}
