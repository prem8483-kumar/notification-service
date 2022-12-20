package com.meesho.notification.models.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@Document(indexName = "sms_details")
public class SMSDetailsDocument {

    @Id
    @JsonProperty("id")
    Integer id;

    @JsonProperty("phone_number")
    String phoneNumber;

    @JsonProperty("message")
    String message;

    @JsonProperty("status")
    String status;

    @JsonProperty("failure_code")
    String failureCode;

    @JsonProperty("failure_comments")
    String failureComments;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    LocalDateTime updatedAt;

}
