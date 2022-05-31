package com.uai.app.ui.cambiar;
import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_adder;
import com.uai.app.logic.SearchManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.BuscarEditarUI;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class CambiarPiso2UI extends UAIJFrame implements CellEditorListener{

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton ConfirmarButton;
    private JTextField textField1;
    boolean change=false;

    public CambiarPiso2UI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        String tituloss = DataManager.getInstance().getPisoTEMPString();
        textArea1.setText(tituloss);

        HashSet<Libro> data = DataManager.getInstance().getData();


        String[] response = null;

        response = BuscarEditarUI.getresponse();


        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    Libro origin = CambiarPisoUI.getBuscar();
                    String eleccion = textField1.getText();

                    Integer piso = Integer.valueOf(eleccion);

                    LibroBuilder builder = new LibroBuilder();
                    builder.withTitulo(origin.getTitulo());
                    builder.withAutor(origin.getAutor());
                    builder.withAnio(origin.getAnio());
                    builder.withEstante_numero(origin.getEstante_numero());
                    builder.withEstante_seccion(origin.getEstante_seccion());
                    builder.withPiso(piso);
                    builder.withEdificio(origin.getEdificio());
                    builder.withSede(origin.getSede());
                    Libro agregar = builder.build();
                    Data_adder.overwrite(origin, agregar);

                    LibroBuilder builderpis = new LibroBuilder();
                    builderpis.withPiso(piso);

                    dispose();

                }
            }
        });
    }

    @Override
    public void editingStopped(ChangeEvent e) {

    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }
}