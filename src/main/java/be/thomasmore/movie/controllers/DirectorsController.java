package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Directors;
import be.thomasmore.movie.repositories.DirectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DirectorsController {
    @Autowired
    private DirectorsRepository directorsRepository;

    @GetMapping("/directorlist")
    public String directors(Model model){
        List<Directors> directors = directorsRepository.findAll();
        model.addAttribute("directors",directors);
        return "directorlist";
    }
}
