package com.realdolmen.jxp010;


import com.realdolmen.jxp010.domain.Movie;
import com.realdolmen.jxp010.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MovieRepositoryTest {

    private MovieRepository repository;

    @Before
    public void init() {
        repository = new MovieRepository();
    }

    @Test
    public void shouldPrintMovieList() throws Exception {
        List<Movie> allMovies = repository.findAllMovies();
        System.out.println(allMovies.size() + " Movies added to list!\n");
        for (Movie movie : allMovies) {
            System.out.println(movie.getTitle() + " - " + movie.getType() + " - " + movie.getFormat());
        }
    }
}
