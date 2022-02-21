package com.asmejiaservice.fraud;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "fruad")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    
    @Id
    private String id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
