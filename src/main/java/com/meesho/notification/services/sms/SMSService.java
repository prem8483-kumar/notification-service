package com.meesho.notification.services.sms;

import com.meesho.notification.models.requests.sms.SMSRequestBody;
import com.meesho.notification.models.response.sms.SMSDetailsResponse;
import com.meesho.notification.models.response.sms.SendSMSResponse;

public interface SMSService {

    public SendSMSResponse sendSMS(SMSRequestBody smsRequestBody);

    public SMSDetailsResponse getSMSDetails(Integer requestId);
}
