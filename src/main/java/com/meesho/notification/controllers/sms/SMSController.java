package com.meesho.notification.controllers.sms;


import com.meesho.notification.models.requests.sms.SMSRequestBody;
import com.meesho.notification.models.response.sms.SMSDetailsResponse;
import com.meesho.notification.models.response.sms.SendSMSResponse;
import com.meesho.notification.services.sms.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SMSController {

    @Autowired
    SMSService smsService;

    @PostMapping(path = "/v1/sms/send")
    public SendSMSResponse sendSMS(@RequestBody SMSRequestBody smsRequestBody) {
        log.info("Send SMS Request: " +  smsRequestBody.toString());
        return smsService.sendSMS(smsRequestBody);
    }

    @GetMapping(path = "/v1/sms/{requestId}")
    public SMSDetailsResponse getSMSDetails(@PathVariable("requestId") Integer requestId) {
        log.info("Get SMS Details for request id: " +  requestId);
        return smsService.getSMSDetails(requestId);
    }



}
