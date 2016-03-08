package com.realdolmen.jxp010.repository;

import com.realdolmen.jxp010.domain.Movie;

import java.util.List;

/**
 * Created by NQRAZ66 on 8/03/2016.
 */
public interface MovieRepositoryAble {
    List<Movie> findAllMovies() throws Exception;
}
