package com.meesho.notification.services.sms;

import com.meesho.notification.entities.sms.SMSRequest;
import com.meesho.notification.requests.sms.SMSRequestBody;
import com.meesho.notification.repositories.sms.SMSRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SMSServiceImpl implements SMSService{

    @Autowired
    SMSRequestRepository smsRequestRepository;

    @Override
    public SMSRequest sendSMS(SMSRequestBody smsRequestBody) {
        log.info("Send SMS Request: " +  smsRequestBody.toString());

        SMSRequest smsRequest = new SMSRequest();
        smsRequest.setPhoneNumber(smsRequestBody.getPhoneNumber());
        smsRequest.setMessage(smsRequestBody.getMessage());
        return smsRequestRepository.save(smsRequest);
    }

    @Override
    public Optional<SMSRequest> getSMSDetails(Integer requestId) {
        log.info("Get SMS Details for request id: " +  requestId);
        return smsRequestRepository.findById(requestId);
    }
}
