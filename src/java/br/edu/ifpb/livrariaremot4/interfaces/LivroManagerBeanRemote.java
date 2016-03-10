/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.interfaces;

import br.edu.ifpb.livrariaremot4.model.Livro;
import javax.ejb.Remote;

/**
 *
 * @author joaopaulo
 */

@Remote
public interface LivroManagerBeanRemote {
    Livro cadastrar(String nome, String titulo, String editora, String isbn, String edicao, String autor);
    Livro alterarLivro(Livro livro);
    Livro consultarPorAutor(String autor);
    Livro consultarPorISBN(String isbn);
    Livro consultarPorTitulo(String titulo);
    Livro remover(Long id);
    Integer numeroBuscas();
}
