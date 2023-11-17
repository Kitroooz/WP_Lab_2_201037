package mk.ukim.finki.lab_1_201037.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab_1_201037.model.Movie;
import mk.ukim.finki.lab_1_201037.repository.MovieRepository;
import mk.ukim.finki.lab_1_201037.repository.ProductionRepository;
import mk.ukim.finki.lab_1_201037.service.MovieService;
import mk.ukim.finki.lab_1_201037.service.ProductionService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final ProductionService productionService;

    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService=productionService;
    }

    @GetMapping
    public String getMoviesPage(Model model, @RequestParam(required = false) String error){
        model.addAttribute("movies", this.movieService.listAll());
        model.addAttribute("error", error);
        return "listMovies";
    }

    @GetMapping("/add")
    public String getAddMoviePage(Model model){
        model.addAttribute("productions", productionService.findAll());
        return "add-movie";
    }

    @PostMapping("/add")
    public String saveMovie(@RequestParam(required = false) Long movieId, @RequestParam String title, @RequestParam String summary, @RequestParam int rating, @RequestParam Long production, HttpServletRequest req, Model model){
        if(movieId!=null)
        {
            Movie movie=movieService.findById(movieId).get();
            movie.setTitle(title);
            movie.setSummary(summary);
            movie.setRating(rating);
            movie.setProduction(productionService.findById(production).get());

        }
        else
        {
            this.movieService.save(title, summary, rating, production);
        }
        return "redirect:/movies";
    }

    @GetMapping("/edit/{movieId}")
    public String getEditMovieForm(@PathVariable Long movieId, Model model) throws NoSuchObjectException {
        Movie movie=null;
        if(movieService.findById(movieId).isPresent())
        {
            movie=movieService.findById(movieId).get();
        }
        if(movie==null)
        {
            return "redirect:/movies?error=Ne e najden film so toj ID";
        }
        model.addAttribute("movie", movie);
        model.addAttribute("productions", productionService.findAll());
        return "add-movie";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) throws NoSuchObjectException {

        if(movieService.findById(id).isPresent())
        {
            movieService.delete(id);
        }
        return "redirect:/movies";
    }

}
