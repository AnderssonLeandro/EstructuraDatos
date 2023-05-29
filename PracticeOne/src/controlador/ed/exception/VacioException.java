/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.exception;

/**
 *
 * @author Andersson
 */
public class VacioException extends Exception{

    public VacioException() {
        super("La posicion no existe");
    }

    public VacioException(String msg) {
        super(msg);
    }
}