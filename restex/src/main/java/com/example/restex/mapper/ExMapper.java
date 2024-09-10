package com.example.restex.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface ExMapper {

    HashMap<String, Object> findById(HashMap<String, Object> parmMap);
}
