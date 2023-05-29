/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.exception.PosicionException;
import controlador.ed.exception.VacioException;
import controlador.ed.listas.pilas.Pilas;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andersson
 */
public class HistorialTablaModelo extends AbstractTableModel {
    
    private Pilas<String> data ;

    public Pilas<String> getData() {
        return data;
    }

    public void setData(Pilas<String> data) {
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
            String p = data.get(i);
            
            return p;
            
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

