package com.aryan.MiniRTB.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.event.ImpressionCreatedEvent;

@Service
public class KafkaProducerService {
    
    private static final String IMPRESSION_TOPIC = "impressions";
    private final KafkaTemplate<String,ImpressionCreatedEvent> kafkaTemplate;

    public KafkaProducerService(
        KafkaTemplate<String,ImpressionCreatedEvent> kafkaTemplate
    ){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishImpressionCreated(ImpressionCreatedEvent event){
        kafkaTemplate.send(IMPRESSION_TOPIC,event);
    }
}
