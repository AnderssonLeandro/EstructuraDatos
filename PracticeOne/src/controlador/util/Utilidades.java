/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.util;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;
import controlador.ed.listas.enlazadas.Nodo;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author Andersson
 */
public class Utilidades {

    public static Double totalVentas(Sucursal s) {
        if (s.getVentas() == null) {
            return 0.0;
        }

        Double total = 0.0;
        Nodo<Venta> aux = s.getVentas().getCabecera();

        while (aux != null) {
            total += aux.getInfo().getValor();
            aux = aux.getSig();
        }
        return total;
    }

    public static Double promedio(Sucursal s) {
        Double suma = totalVentas(s);

        if (suma == 0) {
            return suma;
        }

        return suma / (s.getVentas().size());
    }

    public static String sucursalVentaMayor(ListaEnlazada<Sucursal> sucursales) throws VacioException, PosicionException {
        String sucursalInfo = "";
        double aux = 0;
        double sucursalMayor = 0;

        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i) != null) {
                aux = totalVentas(sucursales.get(i));
                if (sucursalMayor < aux) {
                    sucursalMayor = aux;
                    sucursalInfo = "La sucursal con mayor ventas: " + sucursales.get(i).getNombre();
                }
            }
        }
        
        if (sucursalMayor == 0) {
            return "Ingrese las ventas";
        }
        
        return sucursalInfo;
    }

    public static String sucursalVentaMenor(ListaEnlazada<Sucursal> sucursales) throws VacioException, PosicionException {
        String sucursalInfo = "";
        double aux = 0;
        double sucursalMenor = -1;

        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i) != null) {
                aux = totalVentas(sucursales.get(i));
                if (sucursalMenor > aux || sucursalMenor == -1) {
                    sucursalMenor = aux;
                    sucursalInfo = "La sucursal con menor ventas: " + sucursales.get(i).getNombre();
                }
            }
        }

        return sucursalInfo;
    }
}
