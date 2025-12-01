package cz.czechitas.java2webapps.ukol7.repository;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Vyhledá všechny posty, jejichž datum publikace je menší nebo rovno dnešnímu datu,
     * seřazené sestupně podle data publikace.
     */
    @Query("SELECT p FROM Post p WHERE p.published <= :now ORDER BY p.published DESC ")
    Page<Post> findAllByPublished(Pageable pageable, LocalDate now );
    // dotaz přes název metody: findAllByPublishedLessThanEqualOrderByPublishedDesc

    /**
     * Vyhledá konkrétní post podle slug.
     */
    Optional<Post> findBySlug(String slug);
}
