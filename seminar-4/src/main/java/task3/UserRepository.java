package task3;

import java.util.List;

public class UserRepository {
    private List<User> users; // Предполагаем, что у нас есть список пользователей

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public boolean insertUser(User user) {
// В реальной реализации здесь будет логика добавления пользователя в базу данных
// В данном примере, добавляем пользователя в список
        users.add(user);
        return true; // Пока всегда возвращаем true для успешного создания пользователя
    }

    public User getUserById(int userId) {
// В реальной реализации здесь будет логика получения пользователя из базы данных по ID
// В данном примере, просто ищем пользователя в списке
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null; // Если пользователь не найден, возвращаем null
    }
}

