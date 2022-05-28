package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarEditarUI extends UAIJFrame {
    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextField textField1;
    private JButton buscarButton;
    static String response;

    public static String getresponse() {
        return response;
    }

    public BuscarEditarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        String[] titles = { "titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede" };
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();

                Libro buscar = null;
                try {
                    LibroBuilder builder = new LibroBuilder();
                    builder.withTitulo(eleccion);
                    Libro search = builder.build();

                    buscar = DataManager.getInstance().buscarLibro(search);

                } catch (BookNotFoundException ex) {
                    System.err.println("Libro no encontrado");
                }
                if (buscar!=null){
                    response=buscar.toString();
                    dispose();
                    UIBuilder.buildUI(MostrarEditar.class);
                }
            }
        });
    }
}
