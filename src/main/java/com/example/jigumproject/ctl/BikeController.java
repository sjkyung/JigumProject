package com.example.jigumproject.ctl;


import com.example.jigumproject.dto.apiDto;
import com.example.jigumproject.dto.row;
import com.example.jigumproject.service.BikeService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Tag(name = "공공 api 연결 컨트롤러")
@RequiredArgsConstructor
public class BikeController {

    private  final BikeService bikeService;

    @GetMapping(value = "ListAll")
    public List test() throws IOException {

        log.info("test");
        //bikeService.bikeList();

        List test =new ArrayList();
        return test;
    }


    @GetMapping(value = "bikeList/{Latitude}/{Longitude}")
    public List<row> bikeList(@Parameter(name="Latitude",description = "위도 길이 5글자(소수점 포함)")@PathVariable  String Latitude,@Parameter(name="Longitude",description = "경도 길이 5글자(소수점 포함)") @PathVariable String Longitude){

        log.info("start,end  : {},{} ",Latitude, Longitude);
        List<row> bikeList =bikeService.bikeList(Latitude,Longitude);

        log.info(" bikeList size  : {} ", bikeList.size());
        return bikeList;
    }
}