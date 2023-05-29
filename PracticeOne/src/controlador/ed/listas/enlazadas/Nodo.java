/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.enlazadas;

/**
 *
 * @author Andersson
 */
public class Nodo<E> {

    private E info;
    private Nodo<E> sig;

    public Nodo() {
    }

    public Nodo(E info) {
        this.info = info;
        sig = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getSig() {
        return sig;
    }

    public void setSig(Nodo<E> sig) {
        this.sig = sig;
    }

}
