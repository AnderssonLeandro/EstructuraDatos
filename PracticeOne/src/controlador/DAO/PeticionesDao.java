/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.exception.TopeException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.colas.Colas;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Peticion;

/**
 *
 * @author Andersson
 */
public class PeticionesDao implements DaoInterfaceColas<Peticion> {

    private Conexion conexion;
    private Class clas = Peticion.class;
    private String url;

    public PeticionesDao() {
        this.conexion = new Conexion();
        this.url = Conexion.URL + clas.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(Peticion obj) throws IOException {
        Colas<Peticion> peticiones = listar();

        try {
            peticiones.queue(obj);
        } catch (TopeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        conexion.getXstream().toXML(peticiones, new FileWriter(url));

    }

    @Override
    public void modificar() throws IOException {
        Colas<Peticion> peticiones = listar();

        try {
            peticiones.dequeue();
        } catch (VacioException | PosicionException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }

        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        conexion.getXstream().toXML(peticiones, new FileWriter(url));
    }

    @Override
    public Colas<Peticion> listar() throws IOException {
        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        Colas<Peticion> peticiones = (Colas<Peticion>) conexion.getXstream().fromXML(new FileReader(url));

        return peticiones;
    }

}
