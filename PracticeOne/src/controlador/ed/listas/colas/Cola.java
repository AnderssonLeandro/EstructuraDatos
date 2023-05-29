/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.colas;
import controlador.ed.exception.PosicionException;
import controlador.ed.exception.exception.TopeException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;
/**
 *
 * @author Andersson
 */
public class Cola<E> extends ListaEnlazada<E>{

    private int tope;

    public Cola(int tope) {
        this.tope = tope;
    }

    public boolean isFull() {
        return (size() >= tope);
    }

    public void queue(E data) throws TopeException {
        if (isFull()) {
            throw new TopeException("La cola esta llena");
        }

        this.insertar(data);
    }

    public E dequeue() throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException("La cola vacia");
        }

        return this.delete(0);
    }

    public int getTop() {
        return this.tope;
    }
}

