package com.meesho.notification.utils.kafka;

import com.meesho.notification.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {



    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value(KafkaConstants.SEND_SMS_TOPIC)
    private String sendSmsTopic;


    public void sendMessage(String message) {
        log.info("Published message on topic " + sendSmsTopic + ": " + message  );
        kafkaTemplate.send(sendSmsTopic, message);
    }

}
