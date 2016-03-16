/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.model.dao;

import br.edu.ifpb.livrariaremot4.model.Livro;
import br.edu.ifpb.livrariaremot4.model.LivroLog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author joaopaulo
 */
public class DAOLivro {
    
    private EntityManager em;
    
        public DAOLivro(EntityManager em){
            this.em = em;
        }
     
    public Livro read(Long id){
        return this.em.find(Livro.class, id);
    }
    
    public void persist(Livro livro) throws Exception{
        if(livro.getCodigo() == null){
            this.em.persist(livro);
        }else{
            if(!this.em.contains(livro)){
                if(this.em.find(Livro.class,livro.getCodigo()) == null){
                    throw new Exception("Erro ao atualizar dados");
                }               
            }            
          this.em.merge(livro);
        }    
    }
    
    public Livro delete(Livro livro){
        this.em.remove(livro);        
        return livro;
    }
    
    public List<Livro> readAll(){
        Query query = em.createQuery("SELECT l FROM Livro l");
        return (List<Livro>) query.getResultList();
    }
    
    public List<Livro> readByTitulo(String titulo){
        System.out.println("Consulta Por Titulo!!!");
        return em.createQuery("SELECT l FROM Livro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo)
                .getResultList();
    }
    
    public List<Livro> readByIsbn(String isbn){
        return em.createQuery("SELECT l FROM Livro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn)
                .getResultList();
    }

    public List<Livro> readByAutor(String autor){
        return em.createQuery("SELECT l FROM Livro l WHERE l.autor LIKE :autor")
                .setParameter("autor", autor)
                .getResultList();
    }
    
    public void newLog(Livro livro,String op){
        this.em.persist(new LivroLog(livro,op));
    }
    
    public List<LivroLog> getLog(){
        Query query = em.createQuery("SELECT o FROM LivroLog o");
        return (List<LivroLog>) query.getResultList();
    }
    
}
