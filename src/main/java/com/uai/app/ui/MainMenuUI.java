package com.uai.app.ui;

import com.uai.app.App;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenuUI extends UAIJFrame {

    private JPanel mainPanel;
    private JButton mostrarDatosButton;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton guardarButton;
    private JButton agregarButton;


    public MainMenuUI(String title) {
        super(title);

        this.setMainPanel(mainPanel);

        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(MostrarDatosUI.class);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(EliminarUI.class);
            }

        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(BuscarEditarUI.class);
            }

        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(GuardarUI.class);
            }

        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(AgregarUI.class);
            }

        });

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                App.saveData();
                System.out.println("Terminado");
            }
        });
    }
}
