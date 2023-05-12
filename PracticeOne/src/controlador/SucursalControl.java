/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.ed.list.ListaEnlazada;
import java.awt.List;
import javax.swing.JComboBox;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author andersson
 */

    
 public class SucursalControl {
    private ListaEnlazada<Sucursal> sucursales;
    private Sucursal sucursal;
    private Ventas venta;

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public SucursalControl() {
        sucursales = new Sucursal(null);
    }

    public ListaEnlazada<Sucursal> getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal(new Sucursal());
            sucursales.next = sucursal;
        }
        return sucursal;
    }

    public void setSucursal(NodoLista sucursal) {
        this.sucursal = sucursal;
    }

    private NodoLista getSucursales() {
        return sucursales;
    }

    public void setSucursales(NodoLista sucursales) {
        this.sucursales = sucursales;
    }

    public boolean registrar() throws EspacioException {
        NodoLista UltimoNode = sucursales;
        int cont = 0;

        while (UltimoNode.next != null) {
            UltimoNode = UltimoNode.next;
            cont++;
        }

        if (cont >= 4) {
            throw new EspacioException();
        }

        NodoLista newNode = new NodoLista(new Sucursal());
        UltimoNode.next = newNode;

        Sucursal sucursal = newNode.data;
        sucursal.setVentas(new Ventas[EnumMes.values().length]);

        for (int i = 0; i < EnumMes.values().length; i++) {
            Ventas venta = new Ventas();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;
        }

        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException {
        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.data.getVentas().length - 1) {
                this.sucursal.data.getVentas()[posVenta].setValor(valor);
            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Se debe elegir una sucursal");
        }
        return true;
    }

    public boolean calcularPromedio(Double totalVentas, Enum enumMes) {
        if (totalVentas == null) {
            System.out.println("El total de ventas es cero");
        }
        return true;
    }

    public static JComboBox cargarComboTipo(JComboBox cbx) {
        cbx.removeAllItems();
        for (EnumMes tipo : EnumMes.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
    }

    private static class NodoLista{
        Sucursal data;
        Sucursal next;

        Sucursal(Sucursal data) {
            this.data = data;
            next = null;
        }
    }
}
