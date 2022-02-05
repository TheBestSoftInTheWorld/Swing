package com.example.labs.ui.listeners;

import com.example.labs.model.TodoDemoListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkTaskCompletedClickListener implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent e) {
        //TODO Implement here the action to mark a task as completed
        TableUtil tableUtil = new TableUtil();
        JTable mytable = tableUtil.getTable(e);
        if (mytable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(mytable, "Select the row");
        } else {
            String status=((TodoDemoListModel) mytable.getModel()).changeStatus(mytable.getSelectedRow());
            if(status.equals("OK")) {
                mytable.repaint();
                JOptionPane.showMessageDialog(mytable, "Selected row deleted successfully");
            }else {
                JOptionPane.showMessageDialog(mytable, status);
            }
            }

    }
}
