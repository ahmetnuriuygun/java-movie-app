package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Genres;
import be.thomasmore.movie.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;



    @GetMapping("/genrelist")
    public String genreList(Model model){
        Iterable<Genres> allGenres = genreRepository.findAll();

        model.addAttribute("genres",allGenres);

        return "fragment/navbar.html";
    }

    @GetMapping({"/genredetail","/genredetail/{id}"})
    public String genreDetails(Model model, @PathVariable(required = false)Integer id){
        if(id==null) return "moviedetails";

        Optional<Genres> optionalGenres = genreRepository.findById(id);
        Optional<Genres> optionalPrev = genreRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Genres> optionalNext = genreRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalGenres.isPresent()) {
            Genres genres = optionalGenres.get();
            model.addAttribute("genres", genres);



        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", genreRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", genreRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "genredetail";

    }


}
