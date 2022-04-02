package com.devsuperior.bds02.controllers;

import java.util.List;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cities")
public class CityController {
    
    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(Pageable pageable){
        PageRequest page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));

        List<CityDTO> cityList = service.findAllPaged(page);

        return ResponseEntity.ok().body(cityList);

    }

}
