package org.example.kafkaserver.service;

import lombok.RequiredArgsConstructor;
import org.example.kafkaserver.kafka.Producer;
import org.example.kafkaserver.model.DroneEvent;
import org.example.kafkaserver.util.mapper.DroneMapper;
import org.example.kafkaserver.web.dto.DroneRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DroneService {

    private static final Logger log = LoggerFactory.getLogger(DroneService.class);
    private final DroneMapper mapper;
    private final Producer producer;

    public void sendToKafka(DroneRequest request){

        log.info("Data received: {}", request);
        DroneEvent event = mapper.toEntity(request);
        event.setId(UUID.randomUUID());
        event.setDetectedAt(LocalDateTime.now());

        try{
            producer.sendMessage(event);
            log.info("Data sent: {}", event);
        }catch (Exception e){
            log.error("Error sending data to kafka: {}", e.getMessage());
        }
    }
}
