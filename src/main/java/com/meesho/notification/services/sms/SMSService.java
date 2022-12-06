package com.meesho.notification.services.sms;

import com.meesho.notification.entities.sms.SMSRequest;
import com.meesho.notification.requests.sms.SMSRequestBody;

import java.util.Optional;

public interface SMSService {

    public SMSRequest sendSMS(SMSRequestBody smsRequestBody);

    public Optional<SMSRequest> getSMSDetails(Integer requestId);
}
