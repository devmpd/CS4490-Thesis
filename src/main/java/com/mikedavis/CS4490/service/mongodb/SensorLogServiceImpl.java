package com.mikedavis.CS4490.service.mongodb;

import com.mikedavis.CS4490.model.SensorData;
import com.mikedavis.CS4490.model.SensorLog;
import com.mikedavis.CS4490.model.SensorMeta;
import com.mikedavis.CS4490.mongodao.MongoDAO;
import com.mikedavis.CS4490.service.sql.SensorService;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

@Service
public class SensorLogServiceImpl implements SensorLogService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SensorService sensorService;

    @Autowired
    MongoDAO mongoDAO;

    public SensorLog getSensorLogByID(String id, String date){
        List<DBObject> sensorLogDoc = mongoTemplate.find(new Query(Criteria.where("_id").is(id + "-" + date)), DBObject.class, "5765_tls");
        SensorLog sensorLog = new SensorLog();
        sensorLog.setId(id);
        sensorLog.setDate(date);
        Map<String, String> trendLogData = new LinkedHashMap<String, String>();
        for(DBObject object : sensorLogDoc){
            for(String key : object.keySet()){
                if(key.matches("^\\d{2}:\\d{2}:\\d{2}$")){
                    trendLogData.put(key, object.get(key).toString());
                }
            }
        }
        sensorLog.setData(trendLogData);
        return sensorLog;
    }

    public SensorData getSensorDataByID(String id, String date){
        SensorData sensorData = new SensorData();
        List<SensorLog> trendLog = new ArrayList<>();
        trendLog.add(getSensorLogByID(id, date));
        sensorData.setData(trendLog);
        sensorData.setSensor(sensorService.getSensor(id));
        sensorData.setSensorMeta(getSensorMetaDataByID(id));
        return sensorData;
    }

    public SensorData getSensorDataByDateRange(String id, String start, String end){
        SensorData sensorData = new SensorData();
        sensorData.setSensor(sensorService.getSensor(id));
        sensorData.setSensorMeta(getSensorMetaDataByID(id));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        List<SensorLog> trendLogs = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            trendLogs.add(getSensorLogByID(id, date.toString()));
        }
        sensorData.setData(trendLogs);

        return sensorData;
    }

    public SensorData getAllSensorDataByID(String id){
        SensorData sensorData = new SensorData();
        sensorData.setSensor(sensorService.getSensor(id));
        sensorData.setSensorMeta(getSensorMetaDataByID(id));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String start = sensorData.getSensorMeta().getFirst();
        String end = sensorData.getSensorMeta().getLast();
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        List<SensorLog> trendLogs = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            trendLogs.add(getSensorLogByID(id, date.toString()));
        }
        sensorData.setData(trendLogs);

        return sensorData;
    }

    public SensorMeta getSensorMetaDataByID(String id) {
        SensorMeta sensorMeta = mongoDAO.findSensorMetaById(id);
        return sensorMeta;
    }
}
