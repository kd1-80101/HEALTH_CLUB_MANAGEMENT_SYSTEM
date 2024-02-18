package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.EventDTO;

public interface EventService {
	
	public List<EventDTO> getAllEvents();
	
	public Optional<EventDTO> getEventById(Long id);
	
	public EventDTO createOrUpdateEvent(EventDTO eventDTO);
	
	public void deleteEventById(Long id);

}
