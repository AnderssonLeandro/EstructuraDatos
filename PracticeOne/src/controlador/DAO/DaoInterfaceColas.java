/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO;

import controlador.ed.listas.colas.Colas;
import java.io.IOException;

/**
 *
 * @author Andersson
 */
public interface DaoInterfaceColas<T>{
    
    public void guardar(T obj) throws IOException;
    
    public void modificar() throws IOException;
    
    public Colas<T> listar() throws IOException;
    
}
