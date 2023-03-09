package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private MovieRepository movieRepository;
    @GetMapping({"/","/home"})
    public String home(Model model) {
        Optional<Movies> optionalMovies1 = movieRepository.findById(130128);
        Optional<Movies> optionalMovies2 = movieRepository.findById(112290);
        Optional<Movies> optionalMovies3 = movieRepository.findById(30959);
        model.addAttribute("movie1",optionalMovies1.get());
        model.addAttribute("movie2",optionalMovies2.get());
        model.addAttribute("movie3",optionalMovies3.get());
        return "home";
    }




}
