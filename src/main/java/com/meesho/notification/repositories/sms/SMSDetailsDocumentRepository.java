package com.meesho.notification.repositories.sms;

import com.meesho.notification.models.documents.SMSDetailsDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSDetailsDocumentRepository extends ElasticsearchRepository<SMSDetailsDocument, Integer> {

}
