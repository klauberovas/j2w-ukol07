package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public Page<Post> listPostsByPublished(int page) {
        return postRepository.findAllByPublished(PageRequest.of(page, 20), LocalDate.now());

    }

    /**
     * Vrátí konkrétní post podle slug nebo null pokud neexistuje.
     */
    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }
}
