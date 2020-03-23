package com.mikedavis.CS4490.mapper;

import com.mikedavis.CS4490.model.AdditionalMetadata;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date")
    })
    @Insert("INSERT INTO AdditionalMetadata(title, description, start_date, end_date) VALUES (#{title}, #{description}, #{startDate}, #{endDate})")
    void insertEvent(AdditionalMetadata metadata);

    @Select("SELECT * FROM AdditionalMetadata WHERE sensor_id = #{sensorId}")
    List<AdditionalMetadata> getAdditionalMetadata(String sensorId);
}
