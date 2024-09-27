package com.fatecrl.blog.service;

import java.time.LocalDate;
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
        postagemTeste.setDataPublicacao(LocalDate.of(2024, 9, 26));
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

    public Boolean delete(Long id){
        Blog blog = this.getById(id);
        if(blog != null){
            listaDePostagens.remove(blog);
            return true;
        }
        return false;
    }

    public Boolean update(Blog blogParam){
        Blog postExiste = this.getById(blogParam.getId());
        if(postExiste != null){
            if(blogParam.getTitulo() != null && !blogParam.getTitulo().isEmpty()){
                postExiste.setTitulo(blogParam.getTitulo());
            }
            if(blogParam.getConteudo() != null && !blogParam.getConteudo().isEmpty()){
               postExiste.setConteudo(blogParam.getConteudo()); 
            }
            return true;
        }
        return false;
    }
}



