package com.uai.app.ui.eliminar;

import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarUI extends UAIJFrame {

    private JPanel mainPanel;
    private JButton libroButton;
    private JButton sedeButton;
    private JButton seccionButton;
    private JButton pisoButton;

    public EliminarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        libroButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UIBuilder.buildUI(EliminarLibroUI.class);
                }
            });
        sedeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(EliminarSedeUI.class);}
        });
        pisoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(EliminarPisoUI.class);

            }
        });
        seccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(EliminarSeccionUI.class);

            }
        });
    }
    }
