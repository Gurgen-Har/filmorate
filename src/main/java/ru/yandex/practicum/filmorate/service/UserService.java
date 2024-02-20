package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.FriendStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private UserStorage userStorage;
    private FriendStorage friendStorage;

    @Autowired
    public UserService(@Qualifier("userDbStorage") UserStorage userStorage, FriendStorage friendStorage){
        this.userStorage = userStorage;
        this.friendStorage = friendStorage;
    }

    public void addFriends(Long userId, Long friendId){

        if (userId == friendId) {
            throw new ValidationException("Нельзя добавить в друзья самого себя");
        }
        friendStorage.addFriend(userId,friendId);


    }

    public void deleteFriends(Long userId, Long friendId){
        if (userId == friendId) {
            throw new ValidationException("Нельзя удалить из друзей самого себя");
        }
        friendStorage.deleteFriend(userId,friendId);
    }

    public List<User> getFriends(Long userId){
        List<User> friends = new ArrayList<>();
        if (userId != null) {
            friends = friendStorage.getFriends(userId);
        } else {
            throw new UserNotFoundException("Передан пустой аргумент");
        }
        return friends;
    }
    public List<User> showGeneralsFriend(Long userId, Long friendId){
        User first = userStorage.getUserById(userId);
        User second = userStorage.getUserById(friendId);
        Set<User> intersection = null;
        if (first != null && second != null) {
            intersection = new HashSet<>(friendStorage.getFriends(userId));
            intersection.retainAll(friendStorage.getFriends(friendId));
        } else {
            throw new UserNotFoundException("Передан пустой аргумент");
        }
        return new ArrayList<>(intersection);
    }
}
