/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.model.dao;

import br.edu.ifpb.livrariaremot4.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joaopaulo
 */
public class DAOLivro {
    
    private EntityManager em;
    
        public DAOLivro(EntityManager em){
            this.em = em;
        }
     
    public Livro read(){
        return null;
    }
    
    public Livro update(){
        return null;
    }
    
    public Livro delete(){
        return null;
    }
    
    public List<Livro> readAll(){
        return null;
    }
}
