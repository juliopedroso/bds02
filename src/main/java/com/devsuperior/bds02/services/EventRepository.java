package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

}
