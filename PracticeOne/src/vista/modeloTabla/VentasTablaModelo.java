/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Venta;

/**
 *
 * @author Andersson
 */
public class VentasTablaModelo extends AbstractTableModel {

    ListaEnlazada<Venta> dato;

    @Override
    public int getRowCount() {
        return dato.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        try {
            Venta v = dato.get(fila);

            switch (columna) {
                case 0:
                    return v.getMes();
                case 1:
                    return v.getValor();
            }

            return null;
        } catch (VacioException | PosicionException ex) {
        }

        return null;
    }

    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                return "Mes";
            case 1:
                return "Valor";
        }
        return null;
    }

    public ListaEnlazada<Venta> getDato() {
        return dato;
    }

    public void setDato(ListaEnlazada<Venta> dato) {
        this.dato = dato;
    }

}


