package task3;

public interface DatabaseConnection {
    User getUserByUsername(String username);
    boolean insertUser(User user);
}
