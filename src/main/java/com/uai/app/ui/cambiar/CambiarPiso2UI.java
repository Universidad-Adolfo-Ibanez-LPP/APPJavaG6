package com.uai.app.ui.cambiar;
import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.PisoNotFoundOkUI;
import com.uai.app.exceptions.SedeNotFoundOkUI;
import com.uai.app.exceptions.StringEnIntgerUI;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_adder;
import com.uai.app.logic.SearchManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.BuscarEditarUI;
import com.uai.app.ui.GuardarUI;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

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
                    try{
                        Libro origin = CambiarPisoUI.getBuscar();
                        String eleccion = textField1.getText();
                        Integer piso = Integer.valueOf(eleccion);
                        HashSet<Integer> data = DataManager.getInstance().getPisoTEMP();

                        Integer index = null;
                        Integer num = 0;
                        for (Integer s : data) {
                            if (s.compareTo(piso) == 0) {
                                index = s;
                                num = 1;
                            }
                        }
                        if (index == null) {
                            System.err.println("No se encontro el piso a cambiar");
                            UIBuilder.buildUI(PisoNotFoundOkUI.class); //No implemento excepciones reales por como se escribió cambiarUI

                        } else {
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
                            UIBuilder.buildUI(GuardarUI.class);



                            dispose();
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println("Colocaste un String en donde deberia ir un Int");
                        UIBuilder.buildUI(StringEnIntgerUI.class);
                    }

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