package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class User {
    private Long id;
    private String email;
    private String login;
    private String name;
    private LocalDate birthday;
    Set<Long> friends;
    Map<Long,Boolean> friendStatus;

    public User(Long id, String email, String login, String name, LocalDate birthday, Set<Long> friends) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        if ((name == null) || (name.isEmpty()) || (name.isBlank())) {
            this.name = login;
        }
        this.birthday = birthday;
        this.friends = friends;
        if (friends == null) {
            this.friends = new HashSet<>();
        }
        if (friendStatus == null) {
            this.friendStatus = new HashMap<>();
        }

    }
    public void setName(String name) {
        if ((name == null) || (name.isEmpty()) || (name.isBlank())) {
            this.name = login;
        }
    }

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("email", email);
        values.put("login", login);
        values.put("name", name);
        values.put("birthday", birthday);
        return values;
    }
}
