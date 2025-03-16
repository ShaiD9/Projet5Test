package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.User;
import com.openclassrooms.starterjwt.repository.UserRepository;
import com.openclassrooms.starterjwt.security.services.UserDetailsServiceImpl;
import com.openclassrooms.starterjwt.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    User mockUser = new User();
    Long userId;

    @BeforeEach
    public void init() {
        userId = 1L;
        mockUser.setId(userId);
    }

    @Test
    public void isDeleteCalled() {
        userService.delete(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void isFindByIdCalledAndReturnUser() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        User userResult = userService.findById(userId);

        assertNotNull(userResult);
        assertEquals(userId, userResult.getId());

        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        // Arrange : Création d'un utilisateur fictif
        String email = "test@example.com";
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setEmail(email);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        mockUser.setPassword("password123");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(mockUser));

        // Act : Exécute la méthode
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Assert : Vérifie que les données sont correctes
        assertNotNull(userDetails);
        assertEquals(mockUser.getEmail(), userDetails.getUsername());
        assertEquals(mockUser.getPassword(), userDetails.getPassword());
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        // Arrange : Aucun utilisateur trouvé
        String email = "unknown@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert : Vérifie que l'exception est levée
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(email);
        });

        assertEquals("User Not Found with email: " + email, exception.getMessage());
    }
}
