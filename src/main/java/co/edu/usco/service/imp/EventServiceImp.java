package co.edu.usco.service.imp;

import co.edu.usco.persistence.entity.EventEntity;
import co.edu.usco.persistence.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImp {
    private final EventRepository eventRepository;

    public List<EventEntity> getAll() {
        return eventRepository.findAll();
    }

    public EventEntity getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
    }

    public void create(EventEntity eventEntity) {
        eventRepository.save(eventEntity);
    }

    public void update(Long id, EventEntity eventEntity) {
        EventEntity eventDB = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
        eventDB.setName(eventEntity.getName());
        eventDB.setDate(eventEntity.getDate());
        eventRepository.save(eventDB);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
