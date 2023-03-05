package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    @GetMapping("/home/filter")
    public String homeWithFilter(Model model, @RequestParam(required = false) String keyword){
        List<Movies> movies;
        movies = movieRepository.findMoviesByMovieNameContainingIgnoreCase(keyword);
        model.addAttribute("movies",movies);
        return "home";
    }
}
