package com.example.labs.ui;

import com.example.labs.model.TodoDemoListModel;
import com.example.labs.ui.listeners.AddTaskClickListener;
import com.example.labs.ui.listeners.MarkTaskCompletedClickListener;
import com.example.labs.ui.listeners.RemoveTaskClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JTable table;

    public MainWindow() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("TodoList App");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new BorderLayout());

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(500, 50);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setSize(500,50);


        // Initializing the JTable
        table = new JTable(new TodoDemoListModel());
        table.setBounds(30, 40, 200, 300);


        mainFrame.add(controlPanel, BorderLayout.PAGE_START);
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        mainFrame.add(sp, BorderLayout.CENTER);
        mainFrame.add(statusLabel, BorderLayout.PAGE_END);
        mainFrame.setVisible(true);

    }

    public void showApp() {
        JButton addTodoBtn = new JButton("Add TODO");
        JButton markCompletedBtn = new JButton("Marks TODO as completed");
        JButton removeTodoBtn = new JButton("Remove TODO");

        addTodoBtn.setActionCommand("addTask");
        markCompletedBtn.setActionCommand("markTaskFinished");
        removeTodoBtn.setActionCommand("removeTask");

        addTodoBtn.addActionListener(new AddTaskClickListener());
        markCompletedBtn.addActionListener(new MarkTaskCompletedClickListener());
        removeTodoBtn.addActionListener(new RemoveTaskClickListener());

        controlPanel.add(addTodoBtn);
        controlPanel.add(markCompletedBtn);
        controlPanel.add(removeTodoBtn);

        // Specific cell renderer
        table.getColumnModel().getColumn(1).setCellRenderer(new TaskStatusCellRenderer());


        mainFrame.setVisible(true);
    }

}