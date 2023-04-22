package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        MovieService.addMovie(movie);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        MovieService.addDirector(director);
        return ResponseEntity.ok("success");
    }
    @PutMapping("movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        MovieService.addMovieDirectorPair(movieName, directorName);
        return ResponseEntity.ok("success");
    }

    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = MovieService.getMovieByName(name);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = MovieService.getDirectorByName(name);
        return ResponseEntity.ok(director);
    }

    @GetMapping("movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> movies = MovieService.getMoviesByDirectorName(directorName);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> allMovies = MovieService.findAllMovies();
        return ResponseEntity.ok(allMovies);
    }

    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        MovieService.deleteDirectorByName(directorName);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        MovieService.deleteAllDirectors();
        return ResponseEntity.ok("success");
    }
}
