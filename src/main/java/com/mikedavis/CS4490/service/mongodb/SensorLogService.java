package com.mikedavis.CS4490.service.mongodb;

import com.mikedavis.CS4490.model.SensorData;
import com.mikedavis.CS4490.model.SensorMeta;
import org.json.JSONArray;

public interface SensorLogService {

    JSONArray getSensorJSONDataByID(String id, String date);

    SensorData getSensorDataByID(String id, String date);

    SensorMeta getSensorMetaDataByID(String id);

    SensorData getSensorDataByDateRange(String id, String startDate, String endDate);

    SensorData getAllSensorDataByID(String id);
}
