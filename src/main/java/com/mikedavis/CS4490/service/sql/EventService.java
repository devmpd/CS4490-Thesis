package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.model.Event;

import java.util.List;

public interface EventService {
    public List<Event> getEvents(String clusterId, String buildingId);

    public void addEvent(Event event);
}
