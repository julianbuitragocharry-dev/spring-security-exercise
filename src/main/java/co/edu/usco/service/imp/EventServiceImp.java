package co.edu.usco.service.imp;

import co.edu.usco.persistence.entity.EventEntity;
import co.edu.usco.persistence.repository.EventRepository;
import co.edu.usco.service.EventService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImp implements EventService<EventEntity, Long> {
    private final EventRepository eventRepository;

    @Override
    public List<EventEntity> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public EventEntity getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
    }

    @Override
    public void create(EventEntity eventEntity) {
        eventRepository.save(eventEntity);
    }

    @Override
    public void update(Long id, EventEntity eventEntity) {
        EventEntity eventDB = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
        eventDB.setName(eventEntity.getName());
        eventDB.setDate(eventEntity.getDate());
        eventRepository.save(eventDB);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
