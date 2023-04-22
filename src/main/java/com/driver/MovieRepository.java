package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    static Map<String, Movie> movies  = new HashMap<>();
    static Map<String, Director> directors  = new HashMap<>();
    static Map<Movie, Director> Pair = new HashMap<>();

    public static void addMovie(Movie movie) {
        movies.put(Movie.getName(), movie);
    }

    public static void addDirector(Director director) {
        directors.put(Movie.getName(), director);
    }

    public static void addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movies.get(movieName);
        Director director = directors.get(directorName);
        Pair.put(movie, director);
    }

    public static Movie getMovieByName(String name) {
        return movies.get(name);
    }

    public static Director getDirectorByName(String name) {
        return directors.get(name);
    }

    public static List<String> getMoviesByDirectorName(String directorName) {
        List<String> movieNames = new ArrayList<>();
        for(String name : movies.keySet()){
            if(directors.get(name).equals(directorName)){
                movieNames.add(name);
            }
        }
        return movieNames;
    }

    public static List<Movie> findAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        for(String name : movies.keySet()){
            allMovies.add(movies.get(name));
        }
        return allMovies;
    }

    public static void deleteDirectorByName(String directorName) {
        for(String name : directors.keySet()){
            if(name.equals(directorName)){
                directors.remove(name);
                movies.remove(name);
            }
        }
    }

    public static void deleteAllDirectors() {
        for(String name : directors.keySet()){
            directors.remove(name);
            if(movies.containsKey(name)){
                movies.remove(name);
            }
        }
    }
}
