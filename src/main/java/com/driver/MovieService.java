package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director) {
        if(Objects.nonNull(movieRepository.findMovie(movie)) && Objects.nonNull(movieRepository.findDirector(director))){
            movieRepository.saveMovieDirectorPair(movie, director);
        }
    }

    public Movie findMovie(String name) {
        return movieRepository.findMovie(name);
    }

    public Director findDirector(String name) {
        return movieRepository.findDirector(name);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> movies = movieRepository.getMoviesByDirectorName(directorName);
        return movies;
    }

    public List<String> findAllMovies() {
        List<String> allMovies = movieRepository.findAllMovies();
        return allMovies;
    }

    public void deleteDirectorByName(String director) {
        List<String> moviesToDelete = movieRepository.getMoviesByDirectorName(director);
        movieRepository.removeDirector(director);
        for(String movieName : moviesToDelete){
            movieRepository.removeMovie(movieName);
        }
    }


    public void deleteAllDirectors() {
        List<String> directors = movieRepository.detAllDirector();
        for(String directorName : directors){
            deleteDirectorByName(directorName);
        }
    }
}
