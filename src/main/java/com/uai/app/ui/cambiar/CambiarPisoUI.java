package com.uai.app.ui.cambiar;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.LibroNoEncontradoUI;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarPisoUI extends UAIJFrame {
    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextArea textArea1;
    static Libro buscar;
    static String[] response;

    public static String [] getresponse() {
        return response;
    }
    public static Libro getbuscar() {
        return buscar;
    }

    public static Libro getBuscar() {
        return buscar;
    }

    public CambiarPisoUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String tituloss= DataManager.getInstance().getTitulos();
        textArea1.setText(tituloss);

        String[] titles = { "titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede" };
        buscar=null;

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String eleccion_prev = textField1.getText();
                    String eleccion=SearchManager.getInstance().busquedaTitulo(eleccion_prev);

                    LibroBuilder builder = new LibroBuilder();
                    builder.withTitulo(eleccion);
                    Libro search = builder.build();

                    buscar = SearchManager.getInstance().buscarLibro(search);

                } catch (BookNotFoundException ex) {
                    System.err.println("Libro no encontrado");
                    UIBuilder.buildUI(LibroNoEncontradoUI.class);
                }
                catch (NullPointerException ex) {
                    System.err.println("La busqueda no arrojó resultados");
                    UIBuilder.buildUI(LibroNoEncontradoUI.class);
                }

                if (buscar!=null){
                    response= buscar.getDataToCsv();
                    dispose();
                    UIBuilder.buildUI(CambiarPiso2UI.class);
                }
            }
        });

    }
}


