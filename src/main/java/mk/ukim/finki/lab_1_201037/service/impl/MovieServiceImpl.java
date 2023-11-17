package mk.ukim.finki.lab_1_201037.service.impl;

import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.model.Production;
import mk.ukim.finki.lab_1_201037.repository.ProductionRepository;
import org.springframework.stereotype.Service;
import mk.ukim.finki.lab_1_201037.repository.MovieRepository;
import mk.ukim.finki.lab_1_201037.service.MovieService;

import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    public List<Movie> listAll(){
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text, Integer rating) {
        return movieRepository.findAll().stream().filter(r->r.getTitle().contains(text) && r.getRating()==rating).collect(Collectors.toList());
    }

    public List<Movie> searchMovies(String text){
        return this.movieRepository.searchMovies(text);
    }

    public Optional<Movie> save(String title, String summary, int rating, Long production){
        Production production1 = this.productionRepository.findById(production);
        return movieRepository.save(title,summary,rating,production1);
    }

    public void delete(Long movieId){
        movieRepository.delete(movieId);
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

}
