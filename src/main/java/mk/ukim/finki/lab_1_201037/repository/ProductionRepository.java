package mk.ukim.finki.lab_1_201037.repository;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.lab_1_201037.bootstrap.DataHolder;
import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.model.Production;
import mk.ukim.finki.lab_1_201037.bootstrap.DataHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Repository
public class ProductionRepository {

    public List<Production> findAll(){
        return DataHolder.productionList;
    }
    public Production findById(Long id) {
        return DataHolder.productionList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
