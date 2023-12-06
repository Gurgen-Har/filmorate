package ru.yandex.practicum.filmorate.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exception.ValidationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    private Map<Integer,User> users;
    private  int currentId;

    public UserController(){
        users = new HashMap<>();
        currentId = 0;

    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return new ArrayList<>(users.values());
    }


    @PostMapping(value = "/users")
    public Object createUser(@RequestBody User user){
        try{
            log.info("Поступил POST-запрос о создании пользователя с ID = {}", currentId + 1);
            if (isValid(user)) {
                user.setId(++currentId);
                users.put(user.getId(), user);
            }
        }catch (ValidationException exp){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }catch (NullPointerException exp){
            log.error("Передан пустой аргумент");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return user;
    }
    @PutMapping(value = "/users")
    public Object updateUser(@RequestBody User user) {
        try {
            log.info("Получен PUT-запрос к эндпоинту: '/users' на обновление пользователя с ID={}", user.getId());
            if (user.getId() == null) {
                user.setId(currentId + 1);
            }
            if (isValid(user)) {
                users.put(user.getId(), user);
                currentId++;
            }
        } catch (ValidationException exp) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (NullPointerException exp) {
            log.error("Передан пустой аргумент!");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    private boolean isValid(User user){
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
