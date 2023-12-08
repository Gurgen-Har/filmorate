package ru.yandex.practicum.filmorate.storage;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryUserStorage implements UserStorage {
    Map<Long, User> users;
    Long currentId;
    public InMemoryUserStorage(){
        users = new HashMap<>();
        currentId = 0L;
    }
    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User addUser(User user) {
        if(isValidUser(user)){
            user.setId(++currentId);
            users.put(user.getId(), user);
        }
        return user;
    }


    @Override
    public User updateUser(User user) {
        if(user.getId() == null){
            throw new ValidationException("Передан пустой аргумент");
        }
        if(!users.containsKey(user.getId())){
            throw new UserNotFoundException("Пользователя с таким ID ("+ user.getId() +") нет");
        }
        if(isValidUser(user)){
            users.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public User deleteUserById(Long id) {
        if(id == null){
            throw new ValidationException("Передан пустой аргумент");
        }
        if(!users.containsKey(id)){
            throw new UserNotFoundException("Пользовательс таким ID ("+ id +") не найден");
        }
        return users.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        if(id == null){
            throw new ValidationException("Передан пустой аргумент");
        }
        if(!users.containsKey(id)){
            throw new UserNotFoundException("Пользовательс таким ID ("+ id +") не найден");
        }
        return users.get(id);

    }
    public boolean isValidUser(User user){
        if (user.getEmail().isEmpty() || !user.getEmail().contains("@")){
            throw new ValidationException("Почта не должна быть пустой и должна содержать @");
        }
        if (user.getLogin().isEmpty() || user.getLogin().contains(" ")){
            throw new ValidationException("Логин не должен содержать пробелы и не может быть пустым ");
        }
        if (user.getName().isEmpty()){
            user.setName(user.getLogin());
        }
        if (user.getBirthday().isAfter(LocalDate.now())) {
            throw new ValidationException("Некорректная дата рождения пользователя: " + user.getBirthday());
        }
        return true;
    }
}
