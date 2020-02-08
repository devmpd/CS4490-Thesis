package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.mapper.BuildingMapper;
import com.mikedavis.CS4490.mapper.SensorMapper;
import com.mikedavis.CS4490.model.Building;
import com.mikedavis.CS4490.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService{
    @Autowired
    private SensorMapper sensorMapper;

    @Override
    public Sensor getSensor(String id){
        Sensor test = sensorMapper.getSensor(id);
        return sensorMapper.getSensor(id);
    }

    @Override
    public List<Sensor> getSensorsByBuilding(String buildingId){
        return sensorMapper.getSensorsByBuilding(buildingId);
    }
}
