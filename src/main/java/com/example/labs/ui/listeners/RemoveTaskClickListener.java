package com.example.labs.ui.listeners;

import com.example.labs.model.TodoDemoListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTaskClickListener implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent e) {
        //TODO:: Implement here the action to remove a task from the model.
        TableUtil tableUtil = new TableUtil();
        JTable mytable = tableUtil.getTable(e);
        if (mytable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(mytable, "Select the row");
        } else {
            ((TodoDemoListModel) mytable.getModel()).removeRow(mytable.getSelectedRow());
            mytable.repaint();
            JOptionPane.showMessageDialog(mytable, "Selected row completed successfully");
        }
    }
}
