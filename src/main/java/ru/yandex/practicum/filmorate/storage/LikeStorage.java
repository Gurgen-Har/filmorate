package ru.yandex.practicum.filmorate.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.GenreService;
import ru.yandex.practicum.filmorate.service.MpaService;

import java.util.List;

@Component
public class LikeStorage {
    private final JdbcTemplate jdbcTemplate;
    private MpaService mpaService;
    private GenreService genreService;

    @Autowired
    public LikeStorage(JdbcTemplate jdbcTemplate, MpaService mpaService, GenreService genreService) {
        this.jdbcTemplate = jdbcTemplate;
        this.mpaService = mpaService;
        this.genreService = genreService;
    }
    public void addLike(Long filmId, Long userId) {


    }


    public  void deleteLike(Long filmId, Long userId) {

    }

    public List<Film> getPopular(Integer count) {

    }

    public List<Long> getLikes(Long filmId){

    }

}

