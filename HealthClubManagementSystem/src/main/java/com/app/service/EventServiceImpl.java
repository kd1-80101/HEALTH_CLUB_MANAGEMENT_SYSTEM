package com.app.service;

import com.app.dto.EventDTO;
import com.app.entities.Event;
import com.app.dao.EventDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
    private EventDao eventDao;
    
	@Autowired
	private ModelMapper mapper;

    @Autowired
    public EventServiceImpl(EventDao eventDao, ModelMapper mapper) {
        this.eventDao = eventDao;
        this.mapper = mapper;
    }

	@Override
	public List<EventDTO> getAllEvents() {
		List<Event> events = eventDao.findAll();
        return events.stream()
                     .map(event -> mapper.map(event, EventDTO.class))
                     .collect(Collectors.toList());
	}

	@Override
	public Optional<EventDTO> getEventById(Long id) {
		Optional<Event> eventOptional = eventDao.findById(id);
        return eventOptional.map(event -> mapper.map(event, EventDTO.class));
	}

	@Override
	public EventDTO createOrUpdateEvent(EventDTO eventDTO) {
		 Event event = mapper.map(eventDTO, Event.class);
	        event = eventDao.save(event);
	        return mapper.map(event, EventDTO.class);
	}

	@Override
	public void deleteEventById(Long id) {
		eventDao.deleteById(id);
		
	}

    
}
