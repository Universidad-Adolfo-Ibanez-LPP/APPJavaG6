package com.uai.app.ui;
import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class EliminarLibroUI extends UAIJFrame{
    private JPanel mainPanel;

    private JButton ConfirmarButton;
    private JTextField textField1;
    private JScrollPane Jscroll;
    private JTextArea textArea1;


    public EliminarLibroUI(String title) throws DataNotLoadedException {
        super(title);
        this.setMainPanel(mainPanel);
        String tituloss= DataManager.getInstance().getTitulos();
        textArea1.setText(tituloss);

        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();
                Libro eliminar= new Libro(eleccion);
                DataManager.getInstance().removerLibro(eliminar);
                dispose();
                UIBuilder.buildUI(EliminarLibroUI.class);
            }
        });
    }
}

