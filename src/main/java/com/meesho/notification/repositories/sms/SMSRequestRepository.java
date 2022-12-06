package com.meesho.notification.repositories.sms;

import com.meesho.notification.models.entities.sms.SMSRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SMSRequestRepository extends CrudRepository<SMSRequest, Integer> {

}
