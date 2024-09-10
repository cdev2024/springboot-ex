package com.example.restex.service;

import com.example.restex.dto.ItemDto;
import com.example.restex.mapper.ExMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class RestExService {
    @Autowired
    private ExMapper exMapper;

    public boolean registerItem(ItemDto itemDto) {
        // DB insert

        log.info("service: register...");

        //DB insert가 성공했을 경우 true
        return true;
    }

    public ItemDto getItem(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> res = exMapper.findById(paramMap);

        //ItemDto 타입 리턴
        ItemDto itemDto = new ItemDto();
        itemDto.setId((String)res.get("ID"));
        itemDto.setName((String)res.get("NAME"));

        return itemDto;
    }
}
