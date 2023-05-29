/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.enlazadas.ListaEnlazada;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Sucursal;

/**
 *
 * @author Andersson
 */
public class SucursalDao implements DaoInterface<Sucursal> {

    private Conexion conexion;
    private Class clas = Sucursal.class;
    private String url;

    public SucursalDao() {
        this.conexion = new Conexion();
        this.url = Conexion.URL + clas.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(Sucursal obj) throws IOException {
        ListaEnlazada<Sucursal> listaSucursales = listar();

        listaSucursales.insertar(obj);

        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        conexion.getXstream().toXML(listaSucursales, new FileWriter(url));
    }

    @Override
    public void modificar(Sucursal obj, Integer pos) throws IOException {

        ListaEnlazada<Sucursal> listaSucursales = listar();

        try {
            listaSucursales.modificar(pos, obj);
        } catch (VacioException | PosicionException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }

        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        conexion.getXstream().toXML(listaSucursales, new FileWriter(url));
    }

    @Override
    public ListaEnlazada<Sucursal> listar() throws IOException {
        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        ListaEnlazada<Sucursal> listaSucursales = (ListaEnlazada<Sucursal>) conexion.getXstream().fromXML(new FileReader(url));

        return listaSucursales;
    }

    @Override
    public Sucursal get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


