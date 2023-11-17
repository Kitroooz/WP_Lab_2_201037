package mk.ukim.finki.lab_1_201037.repository;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.lab_1_201037.bootstrap.DataHolder;
import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Repository
public class MovieRepository {

    public List<Movie> findAll(){
        return DataHolder.movieList;
    }

    public List<Movie> searchMovies(String text){
        return DataHolder.movieList.stream().filter(r-> r.getTitle().contains(text)||r.getSummary().contains(text)).collect(Collectors.toList());
    }

    public Optional<Movie> save(String title, String summary, double rating, Production production) {
        DataHolder.movieList.removeIf(i -> i.getTitle().equals(title));
        Movie movie = new Movie(title, summary, rating, production);
        DataHolder.movieList.add(movie);
        return Optional.of(movie);
    }

    public void delete(Long movieId) {
        DataHolder.movieList.removeIf(i -> i.getId().equals(movieId));
    }

    public Optional<Movie> findById(Long id){
        return DataHolder.movieList.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}
