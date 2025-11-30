package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {this.postService = postService;}

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("posts", postService.list());
        return modelAndView;
    }

    @GetMapping("/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("post", postService.singlePost(slug));
        return modelAndView;
    }
}
