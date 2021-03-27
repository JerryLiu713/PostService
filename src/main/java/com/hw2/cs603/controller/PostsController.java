package com.hw2.cs603.controller;

import com.hw2.cs603.model.Posts;
import com.hw2.cs603.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Posts controller
 */
@RestController
@RequestMapping("/api")
public class PostsController {

    protected Logger logger = Logger.getLogger(PostsController.class.getName());

    @Autowired
    PostsRepository postsRepository;

    /**
     * Status check, this function kinds of check API health, checking if service running well or not.
     *
     * @return
     */
    @GetMapping("/status")
    public String getStatus() {
        return "200,OK";
    }

    /**
     * Get the specific posts via id
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Posts getPostsBySubject(@PathVariable("id") Long id) {
        Optional<Posts> postsData = postsRepository.findById(id);
        Posts result;

        if (postsData.isPresent()) {
            result = postsData.get();
            logger.info(result.toString());

            return result;


        } else {
            return null;
        }
    }

    /**
     * Create a new posts and save it to h2 database.
     *
     * @param posts
     * @return
     */
    @PostMapping("/posts")
    public ResponseEntity<Posts> createPosts(@RequestBody Posts posts) {

        try {
            Posts _posts = postsRepository.save(new Posts(posts.getSubject(), posts.getBody()));
            return new ResponseEntity<>(_posts, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
