package com.uai.app.ui;

import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarUI extends UAIJFrame {

    private JPanel mainPanel;
    private JButton libroButton;
    private JButton sedeButton;
    private JButton secciónButton;
    private JButton pisoButton;

    public AgregarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        sedeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(AgregarSedeUI.class);}
        });
    }




}
