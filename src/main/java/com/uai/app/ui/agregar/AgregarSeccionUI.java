package com.uai.app.ui.agregar;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_adder;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarSeccionUI extends UAIJFrame {

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton confirmarButton;

    public AgregarSeccionUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String seccionstring = DataManager.getInstance().getSeccionTEMPString();

        textArea1.setText(seccionstring);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();
                LibroBuilder builder=new LibroBuilder();
                builder.withEstante_seccion(eleccion);
                Libro agregar= builder.build();
                Data_adder.agregarSeccion(agregar);
                dispose();
                UIBuilder.buildUI(AgregarSeccionUI.class);
            }
        });
    }
}
