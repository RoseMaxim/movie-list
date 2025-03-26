package com.example.movie_list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Case-insensitive search by title
    List<Movie> findByTitleContaining(String title);

    // Case-insensitive search by genre
    List<Movie> findByGenre(String genre);

    // Case-insensitive search by director
    List<Movie> findByDirectorContaining(String director);
}
