package com.fatecrl.blog.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.blog.service.BlogService;
import com.fatecrl.blog.model.Blog;

@RestController
@RequestMapping("/postagens")
public class BlogController {

    @Autowired
    private BlogService service;

    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getById(@PathVariable("id") Long id){
        Blog blog = service.getById(id);
        if(blog != null){
            return ResponseEntity.ok(blog);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Blog> postagensPorAutor(@RequestParam(required = false) String autor){
        if (autor != null){
            return listaDePostagens.stream()
                    .filter(_blog -> blog.getAutor().equalsIgnoreCase(autor))
                    .collect(Collectors.toList());
        } else{
            return listaDePostagens;
        }
         

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        service.create(blog);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(blog.getId())
                            .toUri();
        return ResponseEntity.created(location).body(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@RequestBody Blog blog){
        if(service.update(blog)){
            return ResponseEntity.ok(blog);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id")Long id){
        if (service.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
}
