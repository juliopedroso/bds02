package com.devsuperior.bds02.services;

import java.util.List;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<CityDTO> findAllPaged() {

        List<City> list = repository.findAll(Sort.by("name"));

        return list.stream().map(CityDTO::new).toList();
    }

    public CityDTO insert(CityDTO dto) {

        City city = new City();
        city.setName(dto.getName());

        city = repository.save(city);

        return new CityDTO(city);

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not Found " + id);
        }

    }

}
