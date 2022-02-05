package com.example.labs.model;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a example container of tasks that is used to fill the table. You may create another one to implement your "dynamic task
 * model"
 */
public class YourTodoListModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {

        return null;
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "Created at";
            case 1:
                return "Task";
            case 2:
                return "Status";
            default:
                return super.getColumnName(column);
        }
    }
}
