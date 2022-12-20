package com.meesho.notification.adapters;

import com.meesho.notification.models.documents.SMSDetailsDocument;
import com.meesho.notification.models.entities.sms.SMSRequest;

public class ElasticSearchSMSDetailsAdapter {

    public static SMSDetailsDocument smsRequestToSMSDetailsDocument(SMSRequest smsRequest) {

        return SMSDetailsDocument.builder()
                .id(smsRequest.getId())
                .phoneNumber(smsRequest.getPhoneNumber())
                .message(smsRequest.getMessage())
                .status(smsRequest.getStatus())
                .failureCode(smsRequest.getFailureCode())
                .failureComments(smsRequest.getFailureComments())
                .createdAt(smsRequest.getCreatedAt())
                .updatedAt(smsRequest.getUpdatedAt())
                .build();
    }
}
