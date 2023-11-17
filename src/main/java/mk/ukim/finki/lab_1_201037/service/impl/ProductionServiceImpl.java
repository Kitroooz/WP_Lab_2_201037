package mk.ukim.finki.lab_1_201037.service.impl;

import mk.ukim.finki.lab_1_201037.model.Production;
import mk.ukim.finki.lab_1_201037.repository.ProductionRepository;
import mk.ukim.finki.lab_1_201037.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public List<Production> findAll(){
        return this.productionRepository.findAll();
    }

    @Override
    public Optional<Production> findById(Long id) {
        return Optional.of(productionRepository.findById(id));
    }
}
