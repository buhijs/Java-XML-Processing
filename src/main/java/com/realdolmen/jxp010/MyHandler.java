package com.realdolmen.jxp010;


import com.realdolmen.jxp010.domain.Movie;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler{

    private boolean isMovie;
    private boolean isTitle;
    private boolean isType;
    private boolean isFormat;
    private Movie movie;
    private List<Movie> movies = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("movie")) {
            isMovie = true;
            movie = new Movie();
        }
        else if(qName.equals("title")) {
            isTitle = true;
        }
        else if(qName.equals("type")) {
            isType = true;
        }
        else if(qName.equals("format")) {
            isFormat = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("movie")) {
            isMovie = false;
            movies.add(movie);
        }
        else if(qName.equals("title")) {
            isTitle = false;
        }
        else if(qName.equals("type")) {
            isType = false;
        }
        else if(qName.equals("format")) {
            isFormat = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isMovie && isTitle) {
            String title = new String(ch, start, length).trim();
            movie.setTitle(title);
        }
        else if(isMovie && isType) {
            String type = new String(ch, start, length).trim();
            movie.setType(type);
        }
        else if(isMovie && isFormat) {
            String format = new String(ch, start, length).trim();
            movie.setFormat(format);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
