/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.colas.Colas;
import javax.swing.table.AbstractTableModel;
import modelo.Peticion;

/**
 *
 * @author Andersson
 */
public class PeticionTablaModelo extends AbstractTableModel {
    
    private Colas<Peticion> data ;

    public Colas<Peticion> getData() {
        return data;
    }

    public void setData(Colas<Peticion> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Peticion p = data.get(i);
            
            return p.getInfo();
            
        } catch (VacioException | PosicionException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return "INFORMACION";
    }
    
}

