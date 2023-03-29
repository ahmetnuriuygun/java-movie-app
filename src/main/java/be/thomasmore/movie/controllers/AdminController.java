package be.thomasmore.movie.controllers;

import be.thomasmore.movie.model.Post;
import be.thomasmore.movie.repositories.MovieRepository;
import be.thomasmore.movie.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    private @Autowired PostRepository postRepository;

   private @Autowired MovieRepository movieRepository;

    @ModelAttribute("post")
    public Post findPost(@PathVariable(required = false) Integer id) {

        if(id!=null){
            Optional<Post> optionalPost = postRepository.findById(id);
            if (optionalPost.isPresent()) return optionalPost.get();
        }

        return new Post();

    }

    @GetMapping("/postedit/{id}")
    public String postEdit(Model model, @PathVariable int id) {

        return "admin/postedit";
    }

    @PostMapping("/postedit/{id}")
    public String postEditPost( @PathVariable int id, Post post) {
        postRepository.save(post);
        int movieId = post.getMovies().getId();
        return "redirect:/moviedetail/"+movieId;
    }

    @GetMapping("/postnew")
    public String postNew(Model model) {
        model.addAttribute("movies",movieRepository.findAll());
        return "admin/postnew";
    }

    @PostMapping("/postnew")
    public String postNewPost( Post post) {
        logger.info("postNewPost -- new name=" + post.getText() + ", username=" + post.getUsername());
        postRepository.save(post);
        int movieId = post.getMovies().getId();
        return "redirect:/moviedetail/"+movieId;
    }

    @PostMapping("/postdelete/{id}")
    public String postDeletePost(Model model, @PathVariable int id, Post post) {
        int movieId = post.getMovies().getId();
        postRepository.delete(post);
        return "redirect:/moviedetail/"+movieId;
    }
}
