package com.driver;

import java.util.List;

public class MovieService {
    public static void addMovie(Movie movie) {
        MovieRepository.addMovie(movie);
    }

    public static void addDirector(Director director) {
        MovieRepository.addDirector(director);
    }

    public static void addMovieDirectorPair(String movieName, String directorName) {
        MovieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public static Movie getMovieByName(String name) {
        Movie movie = MovieRepository.getMovieByName(name);
        return movie;
    }

    public static Director getDirectorByName(String name) {
        Director director = MovieRepository.getDirectorByName(name);
        return director;
    }

    public static List<String> getMoviesByDirectorName(String directorName) {
        List<String> movies = MovieRepository.getMoviesByDirectorName(directorName);
        return movies;
    }

    public static List<Movie> findAllMovies() {
        List<Movie> allMovies = MovieRepository.findAllMovies();
        return allMovies;
    }

    public static void deleteDirectorByName(String directorName) {
        MovieRepository.deleteDirectorByName(directorName);
    }


    public static void deleteAllDirectors() {
        MovieRepository.deleteAllDirectors();
    }
}
