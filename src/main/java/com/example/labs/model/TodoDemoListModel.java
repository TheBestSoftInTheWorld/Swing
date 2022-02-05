package com.example.labs.model;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a example container of tasks that is used to fill the table. You may create another one to implement your "dynamic task
 * model"
 */
public class TodoDemoListModel extends AbstractTableModel {

    private final List<Task> tasks = new ArrayList<Task>();

   @Override
    public int getRowCount() {
        return 10;
    }


    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        if(tasks.size()>rowIndex) {
            Task t = tasks.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return t.getCreatedAt().format(DateTimeFormatter.ISO_DATE_TIME);
                case 1:
                    return t.getTaskName();
                case 2:
                    return t.getStatus();
                default:
                    return "Unsupported";
            }
        }else{
            return null;
        }

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

    public void removeRow(int row) {
        tasks.remove(row);
    }

    public String changeStatus(int row) {
        if (row > tasks.size()) {
            return "Exception";
        } else if (tasks.get(row).getStatus().equals(TaskStatus.CLOSED)) {
            return "Please select a task with OPENED status";
        } else {
            tasks.get(row).setStatus(TaskStatus.CLOSED);
            return "OK";
        }
    }
    public void addTask(String taskName){
        tasks.add(new Task(taskName));
    }


}
