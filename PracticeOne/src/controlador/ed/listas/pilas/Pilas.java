/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.pilas;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.exception.TopeException;
import controlador.ed.exception.VacioException;

/**
 *
 * @author Andersson
 */
public class Pilas<E> {

    private Pila<E> pila;

    public Pilas(int top) {
        pila = new Pila<>(top);
    }

    public void push(E obj) throws TopeException {
        pila.push(obj);
    }

    public E pop() throws VacioException, PosicionException {
        return pila.pop();
    }

    public int getTop() {
        return pila.getTop();
    }
    
    public int size() {
        return pila.size();
    }
    
    public E get(int pos) throws VacioException, PosicionException {
        return pila.get(pos);
    }
}
