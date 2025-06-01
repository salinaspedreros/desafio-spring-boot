package com.nuevospa.taskmanagement.util;

import com.nuevospa.taskmanagement.entity.User;
import com.nuevospa.taskmanagement.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasswordVerificationRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordVerificationRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        String rawPassword = "admin123";

        Optional<User> userOpt = userRepository.findByUsername("admin");
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            boolean matches = passwordEncoder.matches(rawPassword, user.getPassword());
        } else {
            System.out.println("Usuario 'admin' no encontrado.");
        }
    }
}
