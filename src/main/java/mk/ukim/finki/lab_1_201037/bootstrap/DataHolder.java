package mk.ukim.finki.lab_1_201037.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.model.Production;
import mk.ukim.finki.lab_1_201037.repository.MovieRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Movie> movieList = new ArrayList<Movie>();
    public static List<Production> productionList = new ArrayList<>();

    @PostConstruct
    public void init() {

        for (int i = 1; i < 5; i++){
            productionList.add(new Production("Production " + i, "Country " + i, "Address " + i));
        }

        for (int i = 1; i < 10; i++){
            movieList.add(new Movie("Movie"+i, "Summary"+i, i, productionList.get(1)));
        }
    }
}
