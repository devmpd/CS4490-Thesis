package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.model.Building;
import com.mikedavis.CS4490.model.Sensor;

import java.util.List;

public interface SensorService {

    public Sensor getSensor(String id);

    public List<Sensor> getSensorsByBuilding(String buildingId);
}
