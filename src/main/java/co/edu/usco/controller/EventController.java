package co.edu.usco.controller;

import co.edu.usco.persistence.entity.EventEntity;
import co.edu.usco.service.imp.EventServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("events")
public class EventController {
    private final EventServiceImp eventServiceImp;

    @GetMapping
    public String events(Model model) {
        List<EventEntity> eventsList = eventServiceImp.getAll();
        model.addAttribute("events", eventsList);
        return "events";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("event", new EventEntity());
        return "create_event";
    }

    @PostMapping("create")
    public String save(@ModelAttribute EventEntity event) {
        eventServiceImp.create(event);
        return "redirect:/events";
    }

    @GetMapping("edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        EventEntity event = eventServiceImp.getById(id);
        model.addAttribute("event", event);
        return "edit_event";
    }

    @PostMapping("edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute EventEntity event) {
        eventServiceImp.update(id, event);
        return "redirect:/events";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        eventServiceImp.delete(id);
        return "redirect:/events";
    }
}
