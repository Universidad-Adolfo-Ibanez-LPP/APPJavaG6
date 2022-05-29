package com.uai.app.ui.cambiar;

import com.uai.app.ui.agregar.AgregarPisoUI;
import com.uai.app.ui.agregar.AgregarSeccionUI;
import com.uai.app.ui.agregar.AgregarSedeUI;
import com.uai.app.ui.eliminar.EliminarLibroUI;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarUI extends UAIJFrame {
    private JPanel mainPanel;
    private JButton sedeButton;
    private JButton secciónButton;
    private JButton pisoButton;

    public CambiarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        sedeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(CambiarSedeUI.class);}
        });
        secciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(CambiarSeccionUI.class);}

        });
        pisoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(CambiarPisoUI.class);}


        });
    }
}
