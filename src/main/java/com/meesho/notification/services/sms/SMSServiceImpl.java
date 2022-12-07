package com.meesho.notification.services.sms;

import com.meesho.notification.models.entities.sms.SMSRequest;
import com.meesho.notification.models.requests.sms.SMSRequestBody;
import com.meesho.notification.models.response.sms.SMSDetailsData;
import com.meesho.notification.models.response.sms.SMSDetailsResponse;
import com.meesho.notification.models.response.sms.SendSMSData;
import com.meesho.notification.models.response.sms.SendSMSResponse;
import com.meesho.notification.repositories.sms.SMSRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSServiceImpl implements SMSService{

    @Autowired
    SMSRequestRepository smsRequestRepository;

    @Override
    public SendSMSResponse sendSMS(SMSRequestBody smsRequestBody) {
        log.info("Send SMS Request: " +  smsRequestBody.toString());

        log.info("Get the phone number and message to send and Insert the details in sms_requests table");
        SMSRequest smsRequest = SMSRequest.builder()
                .phoneNumber(smsRequestBody.getPhoneNumber())
                .message(smsRequestBody.getMessage())
                .build();

        smsRequest = smsRequestRepository.save(smsRequest);

        log.info("Create and return response");
        SendSMSData sendSMSData = SendSMSData.builder()
                .requestId(smsRequest.getId())
                .comments("Successfully Sent")
                .build();

        SendSMSResponse sendSMSResponse = SendSMSResponse.builder()
                .data(sendSMSData)
                .build();

        log.info("Publish request_id to kafka topic -> notification.send_sms");
        return sendSMSResponse;
    }

    @Override
    public SMSDetailsResponse getSMSDetails(Integer requestId) {
        log.info("Get SMS Details for request id: " +  requestId);

        SMSRequest smsRequest =  smsRequestRepository.findById(requestId).get();
        SMSDetailsData smsDetailsData = SMSDetailsData.builder()
                .id(smsRequest.getId())
                .phoneNumber(smsRequest.getPhoneNumber())
                .message(smsRequest.getMessage())
                .status(smsRequest.getStatus())
                .failureCode(smsRequest.getFailureCode())
                .failureComments(smsRequest.getFailureComments())
                .build();

        SMSDetailsResponse smsDetailsResponse = SMSDetailsResponse.builder()
                .data(smsDetailsData)
                .build();

        return smsDetailsResponse;
    }
}
