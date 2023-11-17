package mk.ukim.finki.lab_1_201037.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.lab_1_201037.bootstrap.DataHolder;
import mk.ukim.finki.lab_1_201037.repository.ProductionRepository;

@Data
public class Movie {

    String title;
    String summary;
    double rating;
    private Long id;
    private Production production;

    public Movie(String title, String summary, double rating, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.id = (long) (Math.random() * 1000);
        this.production = production;
    }
}
