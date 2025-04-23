package com.bridgelabz.greetingapp.service;


import com.bridgelabz.greetingapp.dto.User;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService implements IGreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = "Hello " + (user.getFirstName() != null ? user.getFirstName() : "")
                + " " + (user.getLastName() != null ? user.getLastName() : "");
        return greetingRepository.save(new Greeting(message.trim()));
    }

    @Override
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editGreeting(Long id, String newMessage) {
        Greeting greeting = greetingRepository.findById(id).orElseThrow();
        greeting.setMessage(newMessage);
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}
