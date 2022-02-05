package com.example.labs.ui.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TableUtil {

    protected JTable getTable(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
        Component[] components1 = topFrame.getContentPane().getComponents();
        JScrollPane scrollPane = (JScrollPane) components1[1];
        JViewport viewport = scrollPane.getViewport();
        JTable mytable = (JTable) viewport.getView();
        return mytable;
    }
}
