package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Directors;
import be.thomasmore.movie.repositories.DirectorsRepository;
import be.thomasmore.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class DirectorsController {
    @Autowired
    private DirectorsRepository directorsRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping({"/directorlist","/directorlist/{filter}"})
    public String directors(Model model, @RequestParam(required = false) String oscar){
        Boolean getOscar = null;

        List<Directors> directors = null;

        if(oscar == null || oscar.equals("all")){
            directors = directorsRepository.findAll();
        }else if(oscar.equals("yes")){
            getOscar = true;
            directors = directorsRepository.findByOscar(getOscar);
        }else if(oscar.equals("no")){
            getOscar = false;
            directors = directorsRepository.findByOscar(getOscar);
        }


        model.addAttribute("directors",directors);
        model.addAttribute("oscar",getOscar);
        return "directorlist";
    }

    @GetMapping({"/directordetail","/directordetail/{id}"})
    public String directorDetails(Model model, @PathVariable(required = false)Integer id){
        if(id==null) return "directordetail";

        Optional<Directors> optionalDirectors = directorsRepository.findById(id);
        Optional<Directors> optionalPrev = directorsRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Directors> optionalNext = directorsRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalDirectors.isPresent()) {
            Directors directors = optionalDirectors.get();
            model.addAttribute("directors", directors);
            model.addAttribute("movies",movieRepository.findByDirectors(directors));

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String  born = dateFormat.format(directors.getBorn());

        model.addAttribute("born",born);


        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", directorsRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", directorsRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "directordetail";

    }
}
