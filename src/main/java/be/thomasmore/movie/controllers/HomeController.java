package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private MovieRepository movieRepository;
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Movies> allMovies = movieRepository.findAll();
        model.addAttribute("movies",allMovies);
        return "home";
    }
}
