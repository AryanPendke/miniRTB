package com.aryan.MiniRTB.service.impl;

import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.event.ImpressionCreatedEvent;
import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.entity.Campaign;
import com.aryan.MiniRTB.entity.Impression;
import com.aryan.MiniRTB.kafka.KafkaProducerService;
import com.aryan.MiniRTB.repository.ImpressionRepository;
import com.aryan.MiniRTB.service.ImpressionService;

@Service
public class ImpressionServiceImpl implements ImpressionService {

    private final ImpressionRepository impressionRepository;
    private final KafkaProducerService kafkaProducerService;

    public ImpressionServiceImpl(ImpressionRepository impressionRepository, KafkaProducerService kafkaProducerService) {
        this.impressionRepository = impressionRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public void recordImpression(Campaign campaign, AdRequest adRequest) {

        Impression impression = new Impression();

        impression.setCampaign(campaign);
        impression.setAdRequest(adRequest);
        impression.setPublisher(adRequest.getPublisher());
        impression.setBidAmount(campaign.getBidAmount());

        Impression saved = impressionRepository.save(impression);

        ImpressionCreatedEvent event =
        new ImpressionCreatedEvent(

                saved.getId(),

                saved.getCampaign().getId(),

                saved.getPublisher().getId(),

                saved.getBidAmount(),

                saved.getCreatedAt()

        );
        kafkaProducerService.publishImpressionCreated(event);
    }
}