package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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

    public void addLike(Long userId, Long filmId){
        Film film = filmStorage.getFilmById(filmId);
        film.getLikes().add(userId);
        filmStorage.updateFilm(film);
    }
    public void deleteLike(Long userId, Long filmId){
        Film film = filmStorage.getFilmById(filmId);
        film.getLikes().remove(userId);
        filmStorage.updateFilm(film);
    }
    public List<Film> showTopFilms(){
        List<Film> topFilm = new ArrayList<>();
        List<Film> tmp = filmStorage.getFilms();
        Collections.sort(tmp, Comparator.comparingLong(film -> film.getLikes().size()));
        if(tmp.size() > 10){
            for(int i = tmp.size() - 1; i > tmp.size() - 11; i--){
                topFilm.add(tmp.get(i));
            }
        }else{
            for(int i = tmp.size() - 1; i >= 0; i--){
                topFilm.add(tmp.get(i));
            }
        }
        return topFilm;
    }

}
