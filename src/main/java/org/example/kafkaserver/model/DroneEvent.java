package org.example.kafkaserver.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DroneEvent {
    private UUID id;
    private String model;
    private Double speed;
    private String coordinates;
    private Double altitude;
    private String detectedBy;
    private LocalDateTime detectedAt;
}