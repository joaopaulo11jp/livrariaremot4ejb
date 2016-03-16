/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author joaopaulo
 */

@Entity
public class LivroLog implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String titulo;
    private String editora;
    private String isbn;
    private String edicao;
    private String autor;
    private String operacao;
    
        public LivroLog(Livro livro,String operacao){
            this.codigo = livro.getCodigo();
            this.titulo = livro.getTitulo();
            this.editora = livro.getEditora();
            this.isbn = livro.getIsbn();
            this.edicao = livro.getEdicao();
            this.autor = livro.getAutor();
            this.operacao = operacao;
        }    
    
        public LivroLog(String titulo, String editora, String isbn, 
                String edicao, String autor){
            this.titulo = titulo;
            this.editora = editora;
            this.isbn = isbn;
            this.edicao = edicao;
            this.autor = autor;
        }
        
        public LivroLog(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
        
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

}
