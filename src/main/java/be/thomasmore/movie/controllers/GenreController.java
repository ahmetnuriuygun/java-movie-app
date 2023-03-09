package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Genres;
import be.thomasmore.movie.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;



    @GetMapping("/genrelist")
    public String genreList(Model model){
        Iterable<Genres> allGenres = genreRepository.findAll();

        model.addAttribute("genres",allGenres);

        return "genrelist";
    }
}
