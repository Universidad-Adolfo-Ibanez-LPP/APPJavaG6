package com.uai.app.ui.eliminar;

import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarOkUI extends UAIJFrame {
    private JPanel mainPanel;
    private JButton OKButton;


    public EliminarOkUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
