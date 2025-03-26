package com.example.movie_list;

import com.example.movie_list.Movie;
import com.example.movie_list.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")  // Enable CORS (if needed)
public class Controller {

    @Autowired
    private MovieRepository movieRepository;

    // Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a new movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/search/title/{title}")
    public List<Movie> searchByTitle(@PathVariable String title) {
        return movieRepository.findByTitleContaining(title);
    }

    @GetMapping("/search/genre/{genre}")
    public List<Movie> searchByGenre(@PathVariable String genre) {
        return movieRepository.findByGenre(genre);
    }

    @GetMapping("/search/director/{director}")
    public List<Movie> searchByDirector(@PathVariable String director) {
        return movieRepository.findByDirectorContaining(director);
    }

    // Get a movie by ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}
