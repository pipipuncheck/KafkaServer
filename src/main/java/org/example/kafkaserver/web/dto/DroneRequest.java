package org.example.kafkaserver.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DroneRequest {

    @NotBlank(message = "Model is required")
    @Size(max = 100, message = "Model must not exceed 100 characters")
    private String model;
    @NotNull(message = "Speed is a must")
    @Positive(message = "Speed must be positive")
    private Double speed;
    @NotBlank(message = "Coordinates are required")
    private String coordinates;
    @NotNull(message = "Altitude is must")
    @Positive(message = "Speed must be positive")
    private Double altitude;
    @NotBlank(message = "Detection device is required")
    @Size(max = 50, message = "Detection device must not exceed 50 characters.")
    private String detectedBy;
}