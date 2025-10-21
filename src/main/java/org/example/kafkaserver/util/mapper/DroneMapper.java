package org.example.kafkaserver.util.mapper;

import org.example.kafkaserver.model.DroneEvent;
import org.example.kafkaserver.web.dto.DroneRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DroneMapper extends Mappable<DroneEvent, DroneRequest> {
}
