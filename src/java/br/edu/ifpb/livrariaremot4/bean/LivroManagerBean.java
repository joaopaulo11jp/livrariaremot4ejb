/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.bean;

import br.edu.ifpb.livrariaremot4.interfaces.LivroManagerBeanRemote;
import br.edu.ifpb.livrariaremot4.model.Livro;
import br.edu.ifpb.livrariaremot4.model.dao.DAOLivro;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joaopaulo
 */
@Stateless(mappedName = "LivroManager")
public class LivroManagerBean implements LivroManagerBeanRemote{

    @PersistenceContext
    private EntityManager em;
    private DAOLivro daolivro;
    
    private void postConstruct(){
        this.daolivro = new DAOLivro(em);
    }    
    
    @Override
    public List<Livro> consultarPorAutor(String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> consultarPorISBN(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> consultarPorTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro remover(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer numeroBuscas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro alterarLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String teste() {
        return "Teste";
    }

    @Override
    public List<Livro> getTodosOsLivros() {
        List<Livro> l = new ArrayList<Livro>();
        l.add(new Livro(new Long(1), "Teste 1", "Editora 1", "1234", "vol 1", "autor 1"));
        l.add(new Livro(new Long(2), "Teste 2", "Editora 2", "4321", "vol 2", "autor 2"));
        
        return l;
    }

    @Override
    public Livro cadastrar(String titulo, String editora, String isbn, String edicao, String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
