package ru.yandex.practicum.filmorate.storage.user;

import ru.yandex.practicum.filmorate.model.User;

import java.util.List;

public interface UserStorage {
    public List<User> getUsers();
    public User create(User user);
    public User deleteUserById(Long id);
    public User updateUser(User user);
    public User getUserById(Long id);
}
