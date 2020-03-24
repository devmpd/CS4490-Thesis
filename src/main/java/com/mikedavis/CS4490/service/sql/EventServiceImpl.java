package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.mapper.EventMapper;
import com.mikedavis.CS4490.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> getEvents(String sensorId, String buildingId){
        return null;
    }

    @Override
    public void addEvent(Event event){
        eventMapper.insertEvent(event);
        System.out.println("Good");
    }
}
