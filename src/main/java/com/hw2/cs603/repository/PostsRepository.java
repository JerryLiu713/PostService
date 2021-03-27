package com.hw2.cs603.repository;

import com.hw2.cs603.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * jpa repository.
 *
 */
public interface PostsRepository extends JpaRepository<Posts,Long> {

    List<Posts> findBySubject(String subject);
}
