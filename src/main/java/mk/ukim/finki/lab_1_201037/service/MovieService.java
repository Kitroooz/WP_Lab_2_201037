package mk.ukim.finki.lab_1_201037.service;

import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.model.Production;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text, Integer rating);
    public Optional<Movie> save(String title, String summary, int rating, Long production);
    public void delete(Long movieId);
    public Optional<Movie> findById(Long id);

}
