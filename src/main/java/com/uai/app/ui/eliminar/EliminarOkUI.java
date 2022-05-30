package com.uai.app.ui.eliminar;

import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarOkUI extends UAIJFrame {
    private JPanel mainPanel;
    private JButton OKButton;
    private JLabel nombre;

    String eleccion2 = EliminarLibroUI.getEleccion2();

    public EliminarOkUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        nombre.setText(eleccion2);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
