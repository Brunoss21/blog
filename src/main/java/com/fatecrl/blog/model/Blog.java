package com.fatecrl.blog.model;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class Blog implements Serializable {

    private long id;
    private String titulo;
    private String conteudo;
    private String autor;
    private Data dataPublicacao;
    
    public Blog(){

    }

    public Blog(Long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Data getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(Data dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Blog other = (Blog) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

}
