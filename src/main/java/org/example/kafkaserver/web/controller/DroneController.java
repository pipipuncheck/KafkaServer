package org.example.kafkaserver.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkaserver.service.DroneService;
import org.example.kafkaserver.web.dto.DroneRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/drones")
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;

    @PostMapping("/detect")
    public ResponseEntity<String> detectDrone(@Valid @RequestBody DroneRequest request) {
        droneService.sendToKafka(request);
        return ResponseEntity.ok("Data has been successfully processed and sent to kafka");
    }
}
