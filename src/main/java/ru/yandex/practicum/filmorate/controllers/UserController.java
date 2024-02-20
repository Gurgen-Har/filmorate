package ru.yandex.practicum.filmorate.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.service.UserService;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final UserStorage userStorage;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserStorage userStorage){
        this.userService = userService;
        this.userStorage = userStorage;
    }
    @GetMapping
    public List<User> getUsers(){
        return userStorage.getUsers();
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable Long id){
        return userService.getFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getGeneralFriends(@PathVariable Long id, @PathVariable Long otherId){
        return userService.showGeneralsFriend(id, otherId);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userStorage.getUserById(id);
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        user = userStorage.create(user);
        return user;
    }
    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable Long id, @PathVariable Long friendId){
        userService.addFriends(id, friendId);
    }
    @PutMapping
    public Object updateUser(@RequestBody User user) {
        user = userStorage.updateUser(user);
        return user;
    }
    @DeleteMapping("/{id}/friends/{friendsId}")
    public void deleteFriend(@PathVariable Long id, @PathVariable Long friendsId){
        userService.deleteFriends(id, friendsId);
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id){
        return userStorage.deleteUserById(id);
    }

}
