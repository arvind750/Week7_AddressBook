package com.bridgelabz.greetingapp.controller;


import com.bridgelabz.greetingapp.dto.User;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hello")
@CrossOrigin("*")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    // UC1 - GET
    @GetMapping
    public String sayHello() {
        return "Hello from BridgeLabz!";
    }

    // UC2 - Query Param
    @GetMapping("/query")
    public String sayHelloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz!";
    }

    // UC3 - Path Variable
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz!";
    }

    // UC4 - POST using User object
    @PostMapping("/post")
    public Greeting sayHelloPost(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    // UC5 - PUT: Path + Query
    @PutMapping("/put/{firstName}")
    public Greeting sayHelloPut(@PathVariable String firstName,
                                @RequestParam String lastName) {
        User user = new User(firstName, lastName);
        return greetingService.addGreeting(user);
    }

    // Extended Features - Get by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreeting(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // Get all greetings
    @GetMapping("/all")
    public List<Greeting> getAll() {
        return greetingService.getAllGreetings();
    }

    // Edit greeting
    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id,
                                 @RequestBody String message) {
        return greetingService.editGreeting(id, message);
    }

    // Delete greeting
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully!";
    }
}
