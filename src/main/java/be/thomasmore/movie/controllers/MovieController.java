package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.repositories.DirectorsRepository;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorsRepository directorsRepository;


    @GetMapping({"/movielist","/movielist/{filter}"})
    public String movieList(Model model,
                            @RequestParam(required = false)String keyword,
                            @RequestParam(required = false) Integer minReleaseDate,
                            @RequestParam(required = false) Integer maxReleaseDate,
                            @RequestParam(required = false) Double imdb)
    {
        List<Movies> movies;

        if(keyword  == null && minReleaseDate == null && maxReleaseDate == null & imdb == null){
            movies = movieRepository.findAll();

        }else{
            movies = movieRepository.findByMovies(keyword,minReleaseDate,maxReleaseDate,imdb);
        }

        model.addAttribute("movies",movies);
        model.addAttribute("keyword",keyword);
        model.addAttribute("minReleaseDate",minReleaseDate);
        model.addAttribute("maxReleaseDate",maxReleaseDate);
        model.addAttribute("imdb",imdb);
       return "movielist";

    }

    @GetMapping({"/moviedetail","/moviedetail/{id}"})
    public String movieDetails(Model model, @PathVariable(required = false)Integer id){
        if(id==null) return "moviedetails";

        Optional<Movies> optionalMovies = movieRepository.findById(id);
        Optional<Movies> optionalPrev = movieRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Movies> optionalNext = movieRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalMovies.isPresent()) {
            Movies movie = optionalMovies.get();
            model.addAttribute("movie", movie);
//            model.addAttribute("directors",directorsRepository.findByMovies(movie));

        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", movieRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", movieRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "moviedetail";

    }

}
