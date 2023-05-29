/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.pilas;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.exception.TopeException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;

/**
 *
 * @author Andersson
 */
public class Pila<E> extends ListaEnlazada<E>{

    private int top;

    public Pila(int top) {
        this.top = top;
    }

    public boolean isFull() {
        return (size()>= top);
    }

    public void push(E info) throws TopeException {
        if (isFull()) {
            throw new TopeException();
        }
        insertarInicio(info);
    }

    public E pop() throws VacioException, PosicionException {
        E data = null;
        if (isEmpty()) {
            throw new VacioException();
        } else {
            return this.delete(0);
        }
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}

