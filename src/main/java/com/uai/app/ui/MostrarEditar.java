package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class MostrarEditar extends UAIJFrame {

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextArea textArea1;
    private JButton editarButton;

    public MostrarEditar(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String response=null;
        response=BuscarEditarUI.getresponse();
        textArea1.setText(response);

    }

}