/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.interfaces;

import br.edu.ifpb.livrariaremot4.model.Livro;
import br.edu.ifpb.livrariaremot4.model.LivroLog;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaopaulo
 */

@Remote
public interface LivroManagerBeanRemote {
    Livro cadastrar(String titulo, String editora, String isbn, String edicao, String autor);
    Livro alterarLivro(Livro livro);
    List<Livro> getTodosOsLivros();
    List<Livro> consultarPorAutor(String autor);
    List<Livro> consultarPorISBN(String isbn);
    List<Livro> consultarPorTitulo(String titulo);
    List<LivroLog> getLogs();
    Livro remover(Long id);
    Integer numeroBuscas();
}
