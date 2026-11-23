package fr.cegos.demospringweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
class ContactsRestController {

    @GetMapping
    public List<String> contacts() {
        return List.of("Cyril", "Léa", "Julien", "Sébastien");
    }

    @GetMapping("/1")
    public String contact() {
        return "Léa";
    }
}
