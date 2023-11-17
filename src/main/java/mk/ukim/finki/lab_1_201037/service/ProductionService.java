package mk.ukim.finki.lab_1_201037.service;

import mk.ukim.finki.lab_1_201037.model.Production;

import java.util.List;
import java.util.Optional;

public interface ProductionService {
    public List<Production> findAll();
    public Optional<Production> findById(Long id);
}
