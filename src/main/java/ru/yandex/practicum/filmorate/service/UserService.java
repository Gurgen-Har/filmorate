package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserStorage userStorage;

    @Autowired
    public UserService(UserStorage userStorage){
        this.userStorage = userStorage;
    }

    public void addFriends(Long userId, Long friendId){
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);
        user.getFriends().add(friendId);
        friend.getFriends().add(userId);
        userStorage.updateUser(user);
        userStorage.updateUser(friend);

    }

    public void deleteFriends(Long userId, Long friendId){
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);
        user.getFriends().remove(friendId);
        friend.getFriends().remove(userId);
        userStorage.updateUser(user);
        userStorage.updateUser(friend);
    }

    public List<User> getFriends(Long userId){
        User user = userStorage.getUserById(userId);
        List<User> friends = new ArrayList<>();
        for(Long i : user.getFriends()){
            friends.add(userStorage.getUserById(i));
        }
        return friends;
    }
    public List<User> showGeneralsFriend(Long userId, Long friendId){
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);
        Set<Long> generalId = new HashSet<>(user.getFriends());
        generalId.retainAll(friend.getFriends());
        List<User> generalFriend = new ArrayList<>();
        for (Long i : generalId){
            generalFriend.add(userStorage.getUserById(i));
        }
        return generalFriend;
    }
}
