package ru.yandex.practicum.filmorate.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;
import ru.yandex.practicum.filmorate.storage.FilmStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;
    private final FilmStorage filmStorage;
    @Autowired
    public FilmController(FilmStorage filmStorage, FilmService filmService){
        this.filmService = filmService;
        this.filmStorage = filmStorage;
    }
    //получение фильмов
    @GetMapping
    public List<Film> getFilms() {
        return filmStorage.getFilms();
    }
    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id){
        return filmStorage.getFilmById(id);
    }

    @GetMapping("/popular")
    public List<Film> getTopFilms(){
        return filmService.showTopFilms();

    }


    @PostMapping
    public Film createFilm(@RequestBody Film film){
        log.info("Получен PUT запрос на создание");
        filmStorage.addFilm(film);
        return film;
    }

    @PutMapping("/{id}/like/{userId}")
    public void addLike(@PathVariable Long id, @PathVariable Long userId ){
        log.info("Получен PUT запрос на лайк");
        filmService.addLike(userId,id);
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film){
        log.info("Получен PUT запрос на апдейт фильма:");
        filmStorage.updateFilm(film);
        return film;
    }

    @DeleteMapping("/{id}/like/{userId}")
    public void deleteLike(@PathVariable Long id, @PathVariable Long userId){
        log.info("Запрос на удаление лайка");
        filmService.deleteLike(userId,id);
    }


}
