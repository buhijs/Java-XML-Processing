package com.realdolmen.jxp010;

import com.realdolmen.movies.Movie;
import com.realdolmen.movies.Movies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainJaxbXjc {
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance("com.realdolmen.movies");
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Movies movies = new Movies();

        Movie movie = new Movie();
        movie.setType("type");
        movie.setFormat("format");
        movie.setTitle("title");

        movies.getMovie().add(movie);

        marshaller.marshal(movies, System.out);
    }
}
