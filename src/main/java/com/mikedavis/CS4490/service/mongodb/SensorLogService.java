package com.mikedavis.CS4490.service.mongodb;

import com.mikedavis.CS4490.model.SensorData;
import com.mikedavis.CS4490.model.SensorMeta;

public interface SensorLogService {

    public SensorData getSensorDataByID(String id, String date);

    public SensorMeta getSensorMetaDataByID(String id);

    public SensorData getSensorDataByDateRange(String id, String startDate, String endDate);

    public SensorData getAllSensorDataByID(String id);
}
