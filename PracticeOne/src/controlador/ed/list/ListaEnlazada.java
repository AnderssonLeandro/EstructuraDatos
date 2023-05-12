/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.list;

/**
 *
 * @author andersson
 */

public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size = 0;

    public NodoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista cabecera) {
        this.cabecera = cabecera;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    public boolean insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (estaVacia()) {

            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
//            for (int i = 0; i < size()-1; i++) {
//                aux = aux.getSig();
//            }
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
        return true;
    }

    public Integer size() {

        return size;
    }

    public void imprimir() throws VacioException {
        if (estaVacia()) {
            throw new VacioException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("----------Lista------------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("----------Lista fin--------------");
        }
    }

    public void insertarInicio(E info) {
        if (estaVacia()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;

        }
    }
}
