/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.bean.log;

import br.edu.ifpb.livrariaremot4.model.Livro;
import br.edu.ifpb.livrariaremot4.model.dao.DAOLivro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author joaopaulo
 */
@Stateless
public class LivroManagerLogBean {
    private DAOLivro daolivro;
    private EntityManager em;
    
        public LivroManagerLogBean(EntityManager em){
            this.em = em;
        }
        
        public LivroManagerLogBean(){}
    
    public void addLog(Livro livro){
        this.daolivro.newLog(livro, "Criação");
    }
    
    public void editLog(Livro livro){
        this.daolivro.newLog(livro, "Edição");
    }
    
    public void removeLog(Livro livro){
        this.daolivro.newLog(livro, "Remoção");
    }
    
    public void setDAOLivro(DAOLivro daolivro){
        this.daolivro = daolivro;
    }
}
