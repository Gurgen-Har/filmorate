package ru.yandex.practicum.filmorate.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FilmController {
    private Map<Integer, Film> films;
    private int currentId;
    public FilmController(){
        films = new HashMap<>();
        currentId = 0;
    }
    //получение фильмов
    @GetMapping("/films")
    public List<Film> getFilms() {
        return new ArrayList<>(films.values());
    }

    @PostMapping(value = "/films")
    public Object createFilm(@RequestBody Film film){
        try{
            log.info("Получен POST запрос к эндпоинту: '/films' на добавление фильма с ID = {}",currentId + 1);
            if (isValid(film)) {
                film.setId(++currentId);
                films.put(film.getId(), film);
            }
        }catch (ValidationException exp){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (NullPointerException npe){
            log.error("Передан пустой аргумент!");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return film;
    }
    @PutMapping(value = "/films")
    public Object updateFilm(@RequestBody Film film){
        try{
            log.info("Получен PUT - запрос на изменение данных по ID = {}", film.getId());

            if (film.getId() == null) {
                film.setId(currentId + 1);
            }
            if (isValid(film)) {
                films.put(film.getId(), film);
                currentId++;
            }
        }catch (ValidationException exp){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }catch (NullPointerException exp){
            log.error("Передан пустой аргумент");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return film;
    }
    boolean isValid(Film film){
        if (film.getName().isEmpty()){
            throw new ValidationException("Название фильма не должно быть пустым");
        }
        if (film.getDescription().length() > 200){
            throw new ValidationException("Описание фильма не должно привышать 200 символов ");
        }
        if (film.getReleaseDate().isBefore(LocalDate.of(1895,12,28))){
            throw new ValidationException("Дата релиза не может быть раньше чем 28.12.1895");
        }
        if (film.getDuration() <= 0){
            throw new ValidationException("Продолжительность фильма должна быть положительной");
        }
        return true;
    }


}
