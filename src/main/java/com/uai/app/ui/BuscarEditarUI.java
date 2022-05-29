package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.mostrarDatos.MostrarEditar;
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
    static Libro buscar;
    static String[] response;

    public static String [] getresponse() {
        return response;
    }
    public static Libro getbuscar() {
        return buscar;
    }

    public BuscarEditarUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        String[] titles = { "titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede" };
        buscar=null;

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eleccion = textField1.getText();

                try {
                    LibroBuilder builder = new LibroBuilder();
                    builder.withTitulo(eleccion);
                    Libro search = builder.build();

                    buscar = SearchManager.getInstance().buscarLibro(search);

                } catch (BookNotFoundException ex) {
                    System.err.println("Libro no encontrado");
                }

                if (buscar!=null){
                    response= buscar.getDataToCsv();
                    dispose();
                    UIBuilder.buildUI(MostrarEditar.class);
                }
            }
        });
    }
}
