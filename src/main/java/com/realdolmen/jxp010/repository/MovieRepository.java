package com.realdolmen.jxp010.repository;

import com.realdolmen.jxp010.MyHandler;
import com.realdolmen.jxp010.domain.Movie;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class MovieRepository implements MovieRepositoryAble {

    @Override
    public List<Movie> findAllMovies() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File("./src/main/resources/movies.xml")));
        MyHandler handler = new MyHandler();
        parser.parse(stream, handler);

        List<Movie> movies = handler.getMovies();


        return movies;
    }
}
