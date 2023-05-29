/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.DAO.SucursalDao;
import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;
import java.io.IOException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author Andersson
 */
public class SucursalControl {
    private ListaEnlazada<Sucursal> sucursales;
    private Sucursal sucursal;
    private SucursalDao sucursalDao;

    public SucursalControl() {
        this.sucursalDao = new SucursalDao();
        try {
            this.sucursales = sucursalDao.listar();
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getCause());
        }
    }

    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ListaEnlazada<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void registrar() {

        ListaEnlazada<Venta> ventas = new ListaEnlazada<>();

        for (int i = 0; i < 12; i++) {
            ventas.insertar(new Venta(i, 0.0, EnumMes.values()[i]));
        }
        sucursal.setVentas(ventas);
        sucursal.setId(sucursales.size() + 1);
        sucursales.insertar(sucursal);

        guardarDao();
    }

    private void guardarDao() {
        try {
            sucursalDao.guardar(sucursal);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void modificarDao(int pos) {
        try {
            System.out.println("Pos -> "+ pos);
            sucursalDao.modificar(sucursal, pos);
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    public void guardarVenta(int pos, double valor) throws VacioException, PosicionException, Exception {

        if (pos >= 0) {
            if (sucursal != null) {
                sucursal.getVentas().get(pos).setValor(valor);
                modificarDao(sucursal.getId() - 1);
            } else {
                throw new VacioException("La sucursal esta vacia");
            }
        } else {
            throw new Exception("La posicion no existe");
        }

    }
}