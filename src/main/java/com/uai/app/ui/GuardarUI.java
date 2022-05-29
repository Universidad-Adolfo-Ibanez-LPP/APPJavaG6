package com.uai.app.ui;

import com.uai.app.App;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardarUI extends UAIJFrame {

    private JPanel mainPanel;
    private JButton OKButton;

    public GuardarUI(String title) {
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