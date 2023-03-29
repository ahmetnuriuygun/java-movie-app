package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class HomeController {
    @Autowired
    private MovieRepository movieRepository;
    @GetMapping({"/","/home"})
    public String home(Model model) {



        Optional<Movies> optionalMovies1 = movieRepository.findById(randomMovie());
        Optional<Movies> optionalMovies2 = movieRepository.findById(randomMovie());
        Optional<Movies> optionalMovies3 = movieRepository.findById(randomMovie());
        model.addAttribute("movie1",optionalMovies1.get());
        model.addAttribute("movie2",optionalMovies2.get());
        model.addAttribute("movie3",optionalMovies3.get());
        return "home";
    }


    public int randomMovie(){
        List<Movies> allMovies  = movieRepository.findAll();
        ArrayList<Integer> movieIdList = new ArrayList<>();

        for(Movies m : allMovies){
            movieIdList.add(m.getId());
        }

        Random r = new Random();
        int randomNumber =  r.nextInt(movieIdList.get(0),movieIdList.get(35));

        while(!movieIdList.contains(randomNumber)){
            randomNumber = r.nextInt(movieIdList.get(0),movieIdList.get(35));
        }

        return randomNumber;
    }




}
