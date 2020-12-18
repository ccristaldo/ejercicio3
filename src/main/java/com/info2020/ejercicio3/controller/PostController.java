package com.info2020.ejercicio3.controller;

import com.info2020.ejercicio3.entity.Post;
import com.info2020.ejercicio3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4/")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/crearpost")
    public ResponseEntity<?> crearPost(@RequestBody Post post){
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);

    }


}
