package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class MovieRepository {
    private Map<String, Movie> moviesMap  = new HashMap<>();
    private Map<String, Director> directorsMap  = new HashMap<>();
    private Map<String, List<String>> Pair = new HashMap<>();

    public void saveMovie(Movie movie) {
        moviesMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director) {
        directorsMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        List<String> currMovieByDirector = new ArrayList<>();
        if(Pair.containsKey(director))
            currMovieByDirector = Pair.get(director);

        currMovieByDirector.add(movie);
        Pair.put(director, currMovieByDirector);
    }

    public Movie findMovie(String name) {
        return moviesMap.get(name);
    }

    public Director findDirector(String name) {
        return directorsMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> movieNames = new ArrayList<>();
        if(Pair.containsKey(directorName)) movieNames = Pair.get(directorName);
        return movieNames;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moviesMap.keySet());
    }

    public void deleteDirectorByName(String directorName) {
        for(String name : directorsMap.keySet()){
            if(name.equals(directorName)){
                directorsMap.remove(name);
                moviesMap.remove(name);
            }
        }
    }

    public void deleteAllDirectors() {
        for(String name : directorsMap.keySet()){
            directorsMap.remove(name);
            if(moviesMap.containsKey(name)){
                moviesMap.remove(name);
            }
        }
    }

    public void removeDirector(String director) {
        directorsMap.remove(director);
        Pair.remove(director);
    }

    public void removeMovie(String movieName) {
        moviesMap.remove(movieName);
    }

    public List<String> detAllDirector() {
        return new ArrayList<>(directorsMap.keySet());
    }
}
