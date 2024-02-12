package task3;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String username, String email) {
        User user = new User(username, email);
        return userRepository.insertUser(user);
    }

    public String getUserEmailById(int userId) {
        User user = userRepository.getUserById(userId);
        return user != null ? user.getEmail() : null;
    }
}