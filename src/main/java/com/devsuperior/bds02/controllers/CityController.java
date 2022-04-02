package com.devsuperior.bds02.controllers;

import java.util.List;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {
    
    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){       

        List<CityDTO> cityList = service.findAllPaged();

        return ResponseEntity.ok().body(cityList);

    }

    @PostMapping()
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto){

        CityDTO city = service.insert(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(city);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityDTO> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
