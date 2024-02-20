package ru.yandex.practicum.filmorate.storage.film;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.FilmNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryFilmStorage implements FilmStorage {
    private Map<Long, Film> films;
    private Long currentId;

    public InMemoryFilmStorage(){
        currentId = 0L;
        films = new HashMap<>();
    }
    @Override
    public Film create(Film film) {
        if(isValidFilm(film)) {
            film.setId(++currentId);
            films.put(film.getId(), film);
        }
        return film;
    }

    @Override
    public Film deleteFilm(Long id) {
        if(!films.containsKey(id)){
            throw new FilmNotFoundException("Такого фильма нет");
        }
        return films.remove(id);
    }



    @Override
    public List<Film> getFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public Film updateFilm(Film film) {
        if(film.getId() == null){
            throw  new ValidationException("Передан пустой аргумент");
        }
        if (!films.containsKey(film.getId())){
            throw new FilmNotFoundException("Такого фильма нет");
        }
        if (isValidFilm(film)) {
            films.put(film.getId(), film);
            currentId++;
        }
        return film;
    }

    @Override
    public Film getFilmById(Long id) {
        if(!films.containsKey(id)){
            throw new FilmNotFoundException("Такого фильма нет");
        }
        return films.get(id);
    }

    public boolean isValidFilm(Film film){
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
