package com.mikedavis.CS4490.mapper;

import com.mikedavis.CS4490.model.AdditionalMetadata;
import com.mikedavis.CS4490.model.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "buildingId", column = "building_id"),
            @Result(property = "clusterId", column = "cluster_id")
    })
    @Insert("INSERT INTO Events(title, description, start_date, end_date, building_id, cluster_id) VALUES (#{title}, #{description}, #{startDate}, #{endDate}, #{buildingId}, #{clusterId})")
    void insertEvent(Event event);

    @Select("SELECT * FROM AdditionalMetadata WHERE sensor_id = #{sensorId}")
    List<AdditionalMetadata> getAdditionalMetadata(String sensorId);
}
