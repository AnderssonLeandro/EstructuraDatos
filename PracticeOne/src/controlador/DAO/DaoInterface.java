/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO;

import controlador.ed.listas.enlazadas.ListaEnlazada;
import java.io.IOException;

/**
 *
 * @author Andersson
 */
public interface DaoInterface<T> {

    public void guardar(T obj) throws IOException;

    public void modificar(T obj, Integer pos) throws IOException;

    public ListaEnlazada<T> listar() throws IOException;

    public T get(Integer id);
}
