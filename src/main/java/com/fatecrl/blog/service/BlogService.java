package com.fatecrl.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.blog.model.Blog;

@Service
public class BlogService {
    private static List<Blog> listaDePostagens = new ArrayList<>();

    private void postagemTeste(){
        Blog postagemTeste = new Blog(0);
        postagemTeste.setId(1L);
        postagemTeste.setTitulo("Primeira Postagem");
        postagemTeste.setConteudo("Primeiro post do blog");
        postagemTeste.setAutor("Bruno Santos");
        postagemTeste.setDataPublicacao(26092024);
        listaDePostagens.add(postagemTeste);
    }

    public BlogService(){
        postagemTeste();
    }

    public List<Blog> getAll(){
        return listaDePostagens;
    }

    public Blog getById(Long id){
        Blog _blog = new Blog(id);
        return listaDePostagens.stream()
                        .filter(b -> b.equals(_blog))
                        .findFirst().orElse((null));
    }

    public Blog get(Blog blog){
        return this.getById(blog.getId());
    }

    public Blog create(Blog blog){
        listaDePostagens.add(blog);
        return blog;
    }






}
