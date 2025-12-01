package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Vrací seznam prvních 10 postů s datem publikace do dnešního dne,
     * seřazených sestupně podle data publikace (od nejnovějšího po nejstarší).
     */
    public List<Post> listPostsByPublished() {
        Page<Post> page = postRepository.findAllByPublished(PageRequest.of(0,10), LocalDate.now());
        return page.getContent();
    }

    /**
     * Vrátí konkrétní post podle slug nebo null pokud neexistuje.
     */
    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }
}
