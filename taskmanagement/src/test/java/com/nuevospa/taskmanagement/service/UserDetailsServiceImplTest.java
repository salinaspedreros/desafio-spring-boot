package com.nuevospa.taskmanagement.service;

import com.nuevospa.taskmanagement.entity.User;
import com.nuevospa.taskmanagement.repository.UserRepository;
import com.nuevospa.taskmanagement.service.UserDetailsServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword("$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZag0u1Me3hVUX0bOZyPsvDhzrKIHm"); // bcrypt admin123
    }

    @Test
    void loadUserByUsername_shouldReturnUserDetails_whenUserExists() {
        when(userRepository.findByUsername("admin")).thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("admin");

        assertEquals("admin", userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));
        verify(userRepository, times(1)).findByUsername("admin");
    }

    @Test
    void loadUserByUsername_shouldThrowException_whenUserNotFound() {
        when(userRepository.findByUsername("notfound")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("notfound");
        });

        verify(userRepository, times(1)).findByUsername("notfound");
    }
}
