package sparkuniverse.table.tablemodel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rafael Dal Prá
 */
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    protected Vector dataVector;
    protected Vector columnIdentifiers;
    protected int[] columnNonEditable;

    public TableModel(Object[][] data, Object[] columnNames, int[] colNotEdit) {
        columnNonEditable = colNotEdit;
        setDataVector(data, columnNames);
    }

    public TableModel(Vector dataVector, Vector columnIdentifiers, int[] colNotEdit) {
        columnNonEditable = colNotEdit;
        setDataVector(dataVector, columnIdentifiers);
    }

    public void setDataVector(Object[][] dataVector, Object[] columnIdentifiers) {
        setDataVector(convertToVector(dataVector), convertToVector(columnIdentifiers));
    }

    public void setDataVector(Vector dataVector, Vector columnIdentifiers) {
        this.dataVector = nonNullVector(dataVector);
        this.columnIdentifiers = nonNullVector(columnIdentifiers);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    private static Vector nonNullVector(Vector v) {
        return (v != null) ? v : new Vector();
    }

    public int getColumnCount() {
        return columnIdentifiers.size();
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public String getColumnName(int column) {
        Object id = null;
        if (column < columnIdentifiers.size()) {
            id = columnIdentifiers.elementAt(column);
        }
        return (id == null) ? super.getColumnName(column) : id.toString();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        return rowVector.elementAt(column);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        
        return true;
    }

    public void setValueAt(Object aValue, int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        rowVector.setElementAt(aValue, column);
        fireTableCellUpdated(row, column);
    }

    public void addRow(Object[] oLinha) {
        insertRow(getRowCount(), convertToVector(oLinha));
    }

    public void addRow(Vector vectorLinha) {
        insertRow(getRowCount(), vectorLinha);
    }

    public void insertRow(int row, Vector rowData) {
        dataVector.insertElementAt(rowData, row);
        justifyRows(row, row + 1);
        fireTableRowsInserted(row, row);
    }

    public void delRow(int nLin) {
        dataVector.removeElementAt(nLin);
        justifyRows(getRowCount(), getRowCount() - 1);
        fireTableRowsDeleted(getRowCount(), getRowCount());
    }

    public void delAllRow() {
        dataVector.removeAllElements();
    }

    protected static Vector convertToVector(Object[] anArray) {
        if (anArray == null) {
            return null;
        }
        Vector v = new Vector(anArray.length);
        for (int i = 0; i < anArray.length; i++) {
            v.addElement(anArray[i]);
        }
        return v;
    }

    protected static Vector convertToVector(Object[][] anArray) {
        if (anArray == null) {
            return null;
        }

        Vector v = new Vector(anArray.length);
        for (int i = 0; i < anArray.length; i++) {
            v.addElement(convertToVector(anArray[i]));
        }
        return v;
    }

    private void justifyRows(int from, int to) {
        dataVector.setSize(getRowCount());
        for (int i = from; i < to; i++) {
            if (dataVector.elementAt(i) == null) {
                dataVector.setElementAt(new Vector(), i);
            }
            ((Vector) dataVector.elementAt(i)).setSize(getColumnCount());
        }
    }
}
