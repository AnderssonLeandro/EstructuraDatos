/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas.enlazadas;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;

/**
 *
 * @author Andersson
 */
public class ListaEnlazada<E> {

    private Nodo<E> cabecera;
    private Integer size = 0;

    public Nodo<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo<E> cabecera) {
        this.cabecera = cabecera;
    }

    public boolean isEmpty() {
        return cabecera == null;
    }

    public void insertar(E info) {
        Nodo<E> nuevo = new Nodo<>(info);
        if (isEmpty()) {
            this.cabecera = nuevo;
            this.size++;
        } else {
            Nodo<E> aux = cabecera;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
    }

    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertar(info);
        } else {
            Nodo<E> nuevo = new Nodo<>(info);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            Nodo<E> aux = cabecera;
            Nodo<E> nuevo = new Nodo<>(info);
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();
            }
            Nodo<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PosicionException();
        }

    }

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    Nodo<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public void modificar(Integer pos, E info) throws VacioException, PosicionException {

        if (isEmpty()) {
            throw new VacioException();
        } else {
            if (pos >= 0 && pos < size()) {
                System.out.println("Entre aca");
                if (pos == 0) {
                    this.cabecera.setInfo(info);
                } else {
                    Nodo<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    aux.setInfo(info);
                }
            } else {
                System.out.println("No entre ;>");
                throw new PosicionException();
            }
        }
    }

    public E delete(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    Nodo<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                    Nodo<E> aux1 = aux.getSig();
                    dato = aux1.getInfo();
                    Nodo<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public void deleteAll() {
        this.cabecera = null;
    }

    public Integer size() {
        return size;
    }

    public void imprimir() throws VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            Nodo<E> aux = cabecera;
            System.out.println("-------Lista-------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("-------Lista Fin-------");
        }

    }
}

