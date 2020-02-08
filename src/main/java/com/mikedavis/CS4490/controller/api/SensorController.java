package com.mikedavis.CS4490.controller.api;

import com.mikedavis.CS4490.model.Sensor;
import com.mikedavis.CS4490.service.sql.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @RequestMapping("/{id}")
    public Sensor getSensor(@PathVariable String id){
        return sensorService.getSensor(id);
    }

    @RequestMapping("/building/{buildingId}")
    public List<Sensor> getSensorsByBuilding(@PathVariable String buildingId){
        return sensorService.getSensorsByBuilding(buildingId);
    }
}
