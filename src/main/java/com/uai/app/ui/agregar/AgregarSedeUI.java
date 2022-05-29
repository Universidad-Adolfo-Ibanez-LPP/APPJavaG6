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

public class AgregarSedeUI extends UAIJFrame {

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton confirmarButton;

    public AgregarSedeUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String sedesstring = DataManager.getInstance().getSedeTEMPString();

        textArea1.setText(sedesstring);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();
                LibroBuilder builder=new LibroBuilder();
                builder.withSede(eleccion);
                Libro agregar= builder.build();
                Data_adder.agregarSede(agregar);
                dispose();
                UIBuilder.buildUI(AgregarSedeUI.class);
            }
        });
    }
}
