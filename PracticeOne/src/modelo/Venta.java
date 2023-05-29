/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Andersson
 */
public class Venta {

    private Integer id;
    private Double valor;
    private EnumMes mes;

    public Venta(Integer id, Double valor, EnumMes mes) {
        this.id = id;
        this.valor = valor;
        this.mes = mes;
    }

    public Venta() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EnumMes getMes() {
        return mes;
    }

    public void setMes(EnumMes mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", valor=" + valor + ", mes=" + mes.toString() + '}';
    }
    
}
