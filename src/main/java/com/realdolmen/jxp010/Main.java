package com.realdolmen.jxp010;

import com.realdolmen.jxp010.domain.Movie;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File("./src/main/resources/movies.xml")));
        MyHandler handler = new MyHandler();
        parser.parse(stream, handler);

        List<Movie> movies = handler.getMovies();
        System.out.println(movies.size() + " movies added to list\n");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - " + movie.getType() + " - " + movie.getFormat());
        }
    }
}
