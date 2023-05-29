/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.exception.exception.TopeException;
import controlador.ed.listas.pilas.Pilas;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Andersson
 */
public class HistorialDao implements DaoInterfacePilas<String> {

    private Conexion conexion;
    private Class clas = String.class;
    private String url;

    public HistorialDao() {
        this.conexion = new Conexion();
        this.url = Conexion.URL + clas.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(String obj) throws IOException {
        Pilas<String> historial = listar();

        try {
            historial.push(obj);
        } catch (TopeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        conexion.getXstream().toXML(historial, new FileWriter(url));
    }

    @Override
    public Pilas<String> listar() throws IOException {
        conexion.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        Pilas<String> peticiones = (Pilas<String>) conexion.getXstream().fromXML(new FileReader(url));

        return peticiones;
    }
}