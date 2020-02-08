package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.model.Building;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BuildingService {

    public Building getBuilding(String id);

    public List<Building> getBuildings();
}
