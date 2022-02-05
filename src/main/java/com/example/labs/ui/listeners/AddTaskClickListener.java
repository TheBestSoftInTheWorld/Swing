package com.example.labs.ui.listeners;

import com.example.labs.model.TodoDemoListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTaskClickListener implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO:: Implement the task here to edit a task and add it to the model.
        // We would expect you to create a model to input the task name.
        TableUtil tableUtil = new TableUtil();
        JTable mytable = tableUtil.getTable(e);
        String taskName = showPopUP(mytable);
        if ((taskName != null) && (taskName.length() > 0)) {
            ((TodoDemoListModel) mytable.getModel()).addTask(taskName);
            mytable.repaint();
            JOptionPane.showMessageDialog(mytable, "Add task completed successfully");
        } else {
            JOptionPane.showMessageDialog(mytable, "Task name is empty");
        }


    }

    private String showPopUP(JTable mytable) {
        String taskName = (String) JOptionPane.showInputDialog(
                mytable,
                "Task name:",
                "Task Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
        return taskName;
    }
}
