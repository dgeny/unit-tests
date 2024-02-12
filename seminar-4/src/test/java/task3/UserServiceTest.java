package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Инициализация Mock-объектов
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser() {
        when(userRepository.insertUser(any(User.class))).thenReturn(true);

        boolean result = userService.createUser("john_doe", "john@example.com");

        assertTrue(result);
        verify(userRepository, times(1)).insertUser(any(User.class));
    }

    @Test
    public void testGetUserEmailById() {
        int userId = 123;
        User mockUser = new User("testuser", "test@example.com");

        when(userRepository.getUserById(userId)).thenReturn(mockUser);

        String email = userService.getUserEmailById(userId);

        assertEquals("test@example.com", email);
        verify(userRepository, times(1)).getUserById(userId);
    }

    @Test
    public void testGetUserEmailById_UserNotFound() {
        int userId = 456;

        when(userRepository.getUserById(userId)).thenReturn(null);

        String email = userService.getUserEmailById(userId);

        assertNull(email);
        verify(userRepository, times(1)).getUserById(userId);
    }
}