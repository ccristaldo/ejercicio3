package com.info2020.ejercicio3.repository;

import com.info2020.ejercicio3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
