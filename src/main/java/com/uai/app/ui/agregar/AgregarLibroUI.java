package com.uai.app.ui.agregar;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.Data_adder;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.GuardarUI;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarLibroUI extends UAIJFrame {

    Libro nuevo_libro = new Libro();
    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JButton agregarButton;

    public AgregarLibroUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String[] titles = {"titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede"};


        String[][] dataTabla = new String[1][4];

        dataTabla[0] = new String[]{"XXX", "XXX", "000", "000", "XXX", "00", "XXX",
                "XXX"} ;


        TableModel tableModel = new DefaultTableModel(dataTabla, titles);

        JTable table = new JTable(tableModel);

        mainTableConatiner.setLayout(new BorderLayout());
        mainTableConatiner.add(new JScrollPane(table), BorderLayout.CENTER);

        mainTableConatiner.add(table.getTableHeader(), BorderLayout.NORTH);

        mainTableConatiner.setVisible(true);
        mainTableConatiner.setSize(10, 10);

        String nombre = table.getModel().getValueAt(0, 0).toString();
        String autor = table.getModel().getValueAt(0, 1).toString();
        Integer anio = Integer.valueOf(table.getModel().getValueAt(0, 2).toString());
        Integer estante_numero = Integer.valueOf(table.getModel().getValueAt(0, 3).toString());
        String estante_seccion = table.getModel().getValueAt(0, 4).toString();
        Integer piso = Integer.valueOf(table.getModel().getValueAt(0, 5).toString());
        String edificio = table.getModel().getValueAt(0, 6).toString();
        String sede = table.getModel().getValueAt(0, 7).toString();




        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LibroBuilder builder = new LibroBuilder();

                builder.withTitulo(nombre);
                builder.withAutor(autor);
                builder.withAnio(anio);
                builder.withEstante_numero(estante_numero);
                builder.withEstante_seccion(estante_seccion);
                builder.withPiso(piso);
                builder.withEdificio(edificio);
                builder.withSede(sede);
                Libro agregar = builder.build();
                Data_adder.agregarLibro(agregar);
                UIBuilder.buildUI(AgregarOkUI.class);
                dispose();

            }
        });
    }


}
