/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.colas;
import controlador.ed.exception.PosicionException;
import controlador.ed.exception.exception.TopeException;
import controlador.ed.exception.VacioException;
/**
 *
 * @author Andersson
 */
public class Colas<E> {

    private Cola<E> cola;

    public Colas(int top) {
        cola = new Cola(top);
    }

    public void queue(E obj) throws TopeException {
        cola.queue(obj);
    }

    public E dequeue() throws VacioException, PosicionException {
        return cola.dequeue();
    }

    public int getTop() {
        return cola.getTop();
    }

    public E get(int index) throws VacioException, PosicionException {
        return cola.get(index);
    }
    
    public int size() {
        return cola.size();
    }
}

