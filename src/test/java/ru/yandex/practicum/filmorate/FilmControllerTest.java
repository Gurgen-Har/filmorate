package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controllers.FilmController;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmControllerTest {
    private Film film;
    private FilmController filmController;

   /*  @BeforeEach
   public void beforeEach(){
       // filmController = new FilmController();
        film = new Film();
        film.setName("Harry Potter");
        film.setDescription("American romantic comedy film directed by Blake Edwards, written by George Axelrod," +
                " adapted from Truman Capote's 1958 novella of the same name.");
        film.setDuration(145);
        film.setReleaseDate(LocalDate.of(1989,10,15));
    }

    @Test
    public void shouldAddFilmWhenAllCorrect() {
        Object film1 = filmController.createFilm(film);
        assertEquals(film, film1, "Переданный и полученный фильм должны совпадать");
        assertEquals(1, filmController.getFilms().size(), "В списке должен быть один фильм");

    }

    @Test
    public void shouldAddFilmWhenFilmIsNull(){
        film = null;
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmNameIsNull(){
        film.setName(null);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmNameIsEmpty(){
        film.setName("");
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmDescriptionMore200Symbols(){
        film.setDescription(film.getDescription() + film.getDescription());
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmDescriptionIsNull(){
        film.setDescription(null);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmReleaseDateIsBefore28121895() {
        film.setReleaseDate(LocalDate.of(1755,5,5));
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmReleaseDateIsNull() {
        film.setReleaseDate(null);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }

    @Test
    public void shouldAddFilmWhenFilmDurationIsNull(){
        film.setDuration(null);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }
    @Test
    public void shouldAddFilmWhenFilmDurationIsZero(){
        film.setDuration(0);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }
    @Test
    public void shouldAddFilmWhenFilmDurationIsNegative(){
        film.setDuration(-1);
        Object object = filmController.createFilm(film);
        assertTrue(object.toString().contains("BAD_REQUEST"),"Должен быть получен 400 ответ от сервера");
        assertEquals(0, filmController.getFilms().size(), "Список фильмов должен быть пустым");
    }*/
}
