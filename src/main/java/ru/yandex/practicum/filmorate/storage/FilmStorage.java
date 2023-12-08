package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.Film;

import java.util.List;

public interface FilmStorage {
    public Film addFilm(Film film);
    public Film deleteFilm(Long id);
    public List<Film> getFilms();
    public Film updateFilm(Film film);
    public Film getFilmById(Long id);
}
