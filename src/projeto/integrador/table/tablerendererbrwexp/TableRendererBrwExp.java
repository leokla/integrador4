package sparkuniverse.table.tablerendererbrwexp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Developer1
 */
public class TableRendererBrwExp extends DefaultTableCellRenderer {

    int row;
    int col;
    JTable table1;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        this.row = row;
        this.col = column;
        this.table1 = table;

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(row == table.getSelectedRow()) {
 
            // this will customize that kind of border that will be use to highlight a row 
            //setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0, 0, 205)));
        } 
 
         return this;
    }

    @Override
    protected void setValue(Object v) {

        Color corGray = new Color(170, 250, 255);

        super.setValue(v);

        if (v == null) {
            return;
        }

        if (table1.getColumnName(col).equals("Recno")) {
            setHorizontalAlignment(SwingConstants.RIGHT);
        } else if ((v != null) && v.getClass().toString().equals("class java.lang.Double")) {

            setHorizontalAlignment(SwingConstants.RIGHT);
        } else if ((v != null) && v.getClass().toString().equals("class java.lang.Integer")) {

            setHorizontalAlignment(SwingConstants.RIGHT);
        } else {
            setHorizontalAlignment(SwingConstants.LEFT);
        }
        super.setValue(v);

        if (row == table1.getSelectedRow()) {
            if (!table1.getColumnName(col).equals("STATUS")) {
                return;
            }
        }
        if (row % 2 == 0) {
            setForeground(Color.black);
            setBackground(corGray);
        } else {
            setForeground(UIManager.getColor("Table.foreground"));
            setBackground(UIManager.getColor("Table.background"));
        }

        Color corAberto = new Color(32, 178, 170);
        Color corEmConfe = new Color(255, 165, 0);
        Color corExcluido = new Color(255, 0, 0);
        Color corFinalizado = new Color(50, 205, 50);
        Color corReconferir = new Color(255, 0, 255);
        Color corB = Color.black;

        if (table1.getColumnName(col).equals("STATUS")) {
            if (v.equals("A")) { // Aberto cinza claro

                setBackground(corAberto);
                setForeground(corAberto);
                setBorder(BorderFactory.createLineBorder(corB, 1));

            } else if (v.equals("C")) { // Em conferencia laranja
                setBackground(corEmConfe);
                setForeground(corEmConfe);
                setBorder(BorderFactory.createLineBorder(corB, 1));

            } else if (v.equals("E")) {// Excluido vermelho
                setBackground(corExcluido);
                setForeground(corExcluido);
                setBorder(BorderFactory.createLineBorder(corB, 1));

            } else if (v.equals("R")) {// Reconferencia roxo
                setBackground(corReconferir);
                setForeground(corReconferir);
                setBorder(BorderFactory.createLineBorder(corB, 1));

            } else if (v.equals("F")) { // Finalizado pronto VERDE
                setBackground(corFinalizado);
                setForeground(corFinalizado);
                setBorder(BorderFactory.createLineBorder(corB, 1));

            }
        }
        return;
    }

}
