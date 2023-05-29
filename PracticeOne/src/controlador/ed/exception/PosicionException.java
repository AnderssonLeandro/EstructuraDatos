/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.exception;

/**
 *
 * @author Andersson
 */
public class PosicionException extends Exception{

    public PosicionException() {
        super("Las posicion no existe");
    }

    public PosicionException(String msg) {
        super(msg);
    }
}