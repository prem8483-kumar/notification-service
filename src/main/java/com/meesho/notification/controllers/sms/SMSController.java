package com.meesho.notification.controllers.sms;


import com.meesho.notification.models.sms.SMSRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SMSController {

    @PostMapping(path = "/v1/sms/send")
    public void sendSMS(@RequestBody SMSRequest smsRequest) {
        log.info("Send SMS Request: " +  smsRequest.toString());
    }

    @GetMapping(path = "/v1/sms/{requestId}")
    public void getSMSDetails(@PathVariable("requestId") String requestId) {
        log.info("Get SMS Details for request id: " +  requestId);
    }



}
