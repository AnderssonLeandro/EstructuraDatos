/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO;

import controlador.ed.listas.pilas.Pilas;
import java.io.IOException;

/**
 *
 * @author Andersson
 */
public interface DaoInterfacePilas <T>{
    
    public void guardar(T obj) throws IOException;
    
    public Pilas<T> listar() throws IOException;
    
}

