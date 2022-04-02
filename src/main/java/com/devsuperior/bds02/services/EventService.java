package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired 
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional()
    public EventDTO update(Long id, EventDTO dto) {

           try {
            Event event = repository.getOne(id);
            
            event.setName(dto.getName());
            event.setDate(dto.getDate());
            event.setUrl(dto.getUrl());
            event.setCity(cityRepository.getOne(dto.getCityId()));
    
            event = repository.save(event);
            return new EventDTO(event);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
}
