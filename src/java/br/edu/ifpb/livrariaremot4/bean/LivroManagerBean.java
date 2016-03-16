/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.bean;

import br.edu.ifpb.livrariaremot4.bean.log.LivroManagerLogBean;
import br.edu.ifpb.livrariaremot4.interfaces.LivroManagerBeanRemote;
import br.edu.ifpb.livrariaremot4.model.Livro;
import br.edu.ifpb.livrariaremot4.model.LivroLog;
import br.edu.ifpb.livrariaremot4.model.dao.DAOLivro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joaopaulo
 */
@Stateless(mappedName = "LivroManager")
@WebService(serviceName = "LivrariaWebService")
public class LivroManagerBean implements LivroManagerBeanRemote{

    @PersistenceContext(unitName = "LivrariaRemot4PU")
    private EntityManager em;
    @EJB
    private LivrariaStatsBean stats;
    @EJB
    private LivroManagerLogBean livroLog;
    private DAOLivro daolivro;
    
    @PostConstruct
    private void postConstruct(){
        this.daolivro = new DAOLivro(em);
        livroLog.setDAOLivro(this.daolivro);
    }    
    
    @Override
    @WebMethod
    public List<Livro> consultarPorAutor(@WebParam(name = "autor") String autor) {
        stats.incrementaConsulta();
        return this.daolivro.readByAutor(autor);
    }

    @Override
    @WebMethod
    public List<Livro> consultarPorISBN(@WebParam(name = "isbn") String isbn) {
        stats.incrementaConsulta();
        return this.daolivro.readByIsbn(isbn);
    }

    @Override
    @WebMethod
    public List<Livro> consultarPorTitulo(@WebParam(name = "titulo") String titulo) {
        stats.incrementaConsulta();
        return this.daolivro.readByTitulo(titulo);
    }

    @Override
    @WebMethod(exclude = true)
    public Livro remover(Long id) {
        Livro livro = this.daolivro.read(id);
        
        if(livro != null)
            this.daolivro.delete(livro);
        
        this.livroLog.removeLog(livro);
        return livro;
    }

    @Override
    @WebMethod
    public Integer numeroBuscas() {
        return stats.getNumeroConsultas();
    }

    @Override
    @WebMethod(exclude = true)
    public Livro alterarLivro(Livro livro) {        
        try {
            this.daolivro.persist(livro);
        } catch (Exception ex) {
            Logger.getLogger(LivroManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.livroLog.editLog(livro);
        return livro;
    }

    @Override
    @WebMethod
    public List<Livro> getTodosOsLivros() {        
        return this.daolivro.readAll();
    }
    
    @Override
    @WebMethod(exclude = true)
    public List<LivroLog> getLogs(){
        return this.daolivro.getLog();
    }

    @Override
    @WebMethod(exclude = true)
    public Livro cadastrar(String titulo, String editora, String isbn, String edicao, String autor) {
        Livro l = null;
        
        try {
            l = new Livro(titulo,editora,isbn,edicao,autor);
            this.daolivro.persist(l);
        } catch (Exception ex) {
            Logger.getLogger(LivroManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.livroLog.addLog(l);
        return l;
    }

}
