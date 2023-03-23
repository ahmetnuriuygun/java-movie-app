package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Actors;
import be.thomasmore.movie.repositories.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ActorsController {
    @Autowired
    private ActorsRepository actorsRepository;

    @GetMapping({"/actorlist","/actorlist/{filter}"})
    public String actorsList(Model model, @RequestParam(required = false) String keyword){

        List<Actors> actors = null;
      if(keyword==null){
          actors = actorsRepository.findAll();
      }else{
          actors = actorsRepository.findByFirstNameContainingIgnoreCase(keyword);
      }
      model.addAttribute("actors",actors);
        model.addAttribute("keyword",keyword);
        return "actorlist";
    }

    @GetMapping({"/actordetail","/actordetail/{id}"})
    public String actorDetails(Model model, @PathVariable(required = false)Integer id){
        if(id==null) return "actordetail";

        Optional<Actors> optionalActors = actorsRepository.findById(id);
        Optional<Actors> optionalPrev = actorsRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Actors> optionalNext = actorsRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalActors.isPresent()) {
            Actors actors = optionalActors.get();
            model.addAttribute("actors", actors);

        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", actorsRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", actorsRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "actordetail";

    }
}
