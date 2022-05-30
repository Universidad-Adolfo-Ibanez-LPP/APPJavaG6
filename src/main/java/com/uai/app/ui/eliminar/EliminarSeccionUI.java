package com.uai.app.ui.eliminar;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.*;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_remover;
import com.uai.app.logic.Verificador;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarSeccionUI extends UAIJFrame {
    private JPanel mainPanel;
    private JScrollPane Jscroll;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton ConfirmarButton;
    public EliminarSeccionUI(String title) throws DataNotLoadedException {
        super(title);
        this.setMainPanel(mainPanel);
        String tituloss= DataManager.getInstance().getSeccionTEMPString();
        textArea1.setText(tituloss);
        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer aux;
                String eleccion = textField1.getText();
                LibroBuilder builder=new LibroBuilder();
                builder.withEstante_seccion(eleccion);
                Libro eliminar= builder.build();
                try {
                    Verificador.Verificarseccion(eliminar);
                    aux= Data_remover.removerSeccion(eliminar);
                    if (aux==1) {
                        dispose();
                        System.out.println("Se ha eliminado la seccion: " + eleccion);
                        UIBuilder.buildUI(EliminarSeccionUI.class);
                    }
                } catch (LibroAsociadoException ex) {
                    System.err.println("No es posible eliminarlo pues tiene un libro asociado");
                    UIBuilder.buildUI(EliminarNoOkUI.class);
                }
                catch (SeccionNotFoundException ex){
                    System.err.println("No se encontró la sección a eliminar");
                    UIBuilder.buildUI(SeccionNotFoundOkUI.class);

                }
            }

        });

    }
    }



