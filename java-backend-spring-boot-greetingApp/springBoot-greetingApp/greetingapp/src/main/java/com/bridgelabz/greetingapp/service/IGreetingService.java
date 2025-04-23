package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.User;
import com.bridgelabz.greetingapp.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Optional<Greeting> getGreetingById(Long id);
    List<Greeting> getAllGreetings();
    Greeting editGreeting(Long id, String newMessage);
    void deleteGreeting(Long id);
}

