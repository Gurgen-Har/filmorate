package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controllers.UserController;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserControllerTest {
    private User user;
    private UserController userController;

   /* @BeforeEach
    public void beforeEach(){
        user = new User();
        //userController = new UserController();
        user.setName("MyName");
        user.setEmail("My@mayl.ru");
        user.setLogin("MyPower");
        user.setBirthday(LocalDate.of(1980,12,11));
    }

    @Test
    public void shouldAddUserWhenAllCorrect(){
        Object object = userController.createUser(user);
        assertEquals(user, object, "Переданный и полученный пользователь должны совпадать ");
        assertEquals(1, userController.getUsers().size(), "В списке должен быть один поьзователь");
    }

    @Test
    public void shouldAddUserWhenUserIsNull(){
        user = null;
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пуст");
    }

    @Test
    public void shouldAddUserWhenUserEmailIsNull(){
        user.setEmail(null);
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пуст");
    }

    @Test
    public void shouldAddUserWhenUserEmailIsEmpty(){
        user.setEmail("");
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пуст");
    }

    @Test
    public void shouldAddUserWhenUserLoginIsContainsSpace(){
        user.setLogin("Max Power");
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пуст");

    }

    @Test
    public void shouldAddUserWhenUserNameIsEmpty(){
        user.setName("");
        Object object = userController.createUser(user);
        assertEquals(((User) object).getName(), user.getLogin(), "Имя и логин пользователя должны совпадать");
        assertEquals(1, userController.getUsers().size(), "В списке должен быть один пользователь");
    }
    @Test
    public void shouldAddUserWhenUserNameIsNull(){
        user.setName(null);
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пуст");

    }

    @Test
    public void shouldAddUserWhenUserBirthdayInFuture() {
        user.setBirthday(LocalDate.now().plusDays(1));
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пустым");
    }

    // проверка контроллера, когда даты рождения пользователя не существует
    @Test
    public void shouldAddUserWhenUserBirthdayIsNull() {
        user.setBirthday(null);
        Object object = userController.createUser(user);
        assertTrue(object.toString().contains("BAD_REQUEST"), "Должен быть получен 400 ответ от сервера");
        assertEquals(0, userController.getUsers().size(), "Список пользователей должен быть пустым");
    }*/
}
