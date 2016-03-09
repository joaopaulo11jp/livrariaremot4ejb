/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.bean;

import br.edu.ifpb.livrariaremot4.interfaces.LivroManagerBeanRemote;
import br.edu.ifpb.livrariaremot4.model.Livro;
import javax.ejb.Stateless;

/**
 *
 * @author joaopaulo
 */
@Stateless
public class LivroManagerBean implements LivroManagerBeanRemote{

    @Override
    public Livro cadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro alterarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultarPorAutor(String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultarPorISBN(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultarPorTitulo(String titulo) {
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

}
