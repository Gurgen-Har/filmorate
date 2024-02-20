package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.FilmNotFoundException;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.LikeStorage;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.*;

@Service
public class FilmService {
    FilmStorage filmStorage;
    UserStorage userStorage;
    LikeStorage likeStorage;
    @Autowired
    public FilmService(@Qualifier("filmDbStorage") FilmStorage filmStorage,
                       @Qualifier("userDbStorage") UserStorage userStorage){
        this.filmStorage = filmStorage;
        this.userStorage = userStorage;
    }

    public void addLike(Long filmId, Long userId){
        Film film = filmStorage.getFilmById(filmId);
        if (film != null) {
            if (userStorage.getUserById(userId) != null) {
                likeStorage.addLike(filmId, userId);
            } else {
                throw new UserNotFoundException("Пользователь с ID = " + userId + "не найден");
            }
        } else {
            throw new FilmNotFoundException("Фильм с ID = " + filmId + "не найден");
        }
    }
    public void deleteLike(Long filmId, Long userId){
        Film film = filmStorage.getFilmById(filmId);
        if (film != null) {
            if (userStorage.getUserById(userId) != null) {
                likeStorage.deleteLike(filmId,userId);
            } else {
                throw new UserNotFoundException("Пользователь с ID = " + userId + "не найден");
            }
        } else {
            throw new FilmNotFoundException("Фильм с ID = " + filmId + "не найден");
        }

    }
    public List<Film> getPopular(Integer count){
        if (count < 1) {
            new ValidationException("Количество фильмов для выввода не должно быть меньше 1");
        }

        return likeStorage.getPopular(count);
    }

}
