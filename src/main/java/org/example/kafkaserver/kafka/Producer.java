package org.example.kafkaserver.kafka;

import lombok.RequiredArgsConstructor;
import org.example.kafkaserver.model.DroneEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, DroneEvent> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private String topic;

    public void sendMessage(DroneEvent event){
        kafkaTemplate.send(topic, event);
    }
}
