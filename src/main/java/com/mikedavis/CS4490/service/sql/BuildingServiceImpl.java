package com.mikedavis.CS4490.service.sql;

import com.mikedavis.CS4490.mapper.BuildingMapper;
import com.mikedavis.CS4490.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> getBuildings(){
        return buildingMapper.getBuildings();
    }

    @Override
    public Building getBuilding(String id){
        return buildingMapper.getBuilding(id);
    }
}
