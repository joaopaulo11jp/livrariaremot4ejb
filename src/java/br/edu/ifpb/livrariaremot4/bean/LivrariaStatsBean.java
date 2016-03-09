/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.bean;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author joaopaulo
 */
@Singleton
@LocalBean
public class LivrariaStatsBean {
    private int consultas;
    
    public void incrementaConsulta(){
        ++consultas;
    }
    
    public int getNumeroConsultas(){
        return consultas;
    }
    
}
