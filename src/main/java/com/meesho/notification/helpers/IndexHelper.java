package com.meesho.notification.helpers;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.json.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meesho.notification.adapters.ElasticSearchSMSDetailsAdapter;
import com.meesho.notification.constants.ElasticSearchConstants;
import com.meesho.notification.models.documents.SMSDetailsDocument;
import com.meesho.notification.models.entities.sms.SMSRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class IndexHelper {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ElasticsearchClient elasticsearchClient;

    @Value(ElasticSearchConstants.ES_SMS_DETAILS_INDEX_NAME)
    private String smsDetailsIndexName;

    public void indexSMSDetailsData(SMSRequest smsRequest) {

        log.info("Indexing the sms details document in elastic search" );
        SMSDetailsDocument smsDetailsDocument = ElasticSearchSMSDetailsAdapter.smsRequestToSMSDetailsDocument(smsRequest);

        IndexRequest.Builder<SMSDetailsDocument> indexReqBuilder = new IndexRequest.Builder<>();
        indexReqBuilder.index(smsDetailsIndexName);
        indexReqBuilder.id(String.valueOf(smsDetailsDocument.getId()));
        indexReqBuilder.document(smsDetailsDocument);

        try{
            IndexResponse response = elasticsearchClient.index(indexReqBuilder.build());
            log.info("Indexed with index and version: " + response.index() + " , " + response.version());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
