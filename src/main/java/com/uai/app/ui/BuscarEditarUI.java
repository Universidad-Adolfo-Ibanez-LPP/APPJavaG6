package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarEditarUI extends UAIJFrame {
    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextField textField1;
    private JButton buscarButton;

    public BuscarEditarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        String[] titles = { "titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede" };
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();
                Libro buscar= null;
                try {
                    buscar = DataManager.getInstance().buscarLibro(new Libro(eleccion));

                } catch (BookNotFoundException ex) {
                    System.err.println("Libro no encontrado");
                }
            }
        });
    }
}
