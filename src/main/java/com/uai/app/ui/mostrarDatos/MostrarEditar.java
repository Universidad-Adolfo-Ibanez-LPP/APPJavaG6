package com.uai.app.ui.mostrarDatos;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_adder;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.BuscarEditarUI;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class MostrarEditar extends UAIJFrame implements CellEditorListener{

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JButton editarButton;
    boolean change=false;

    public MostrarEditar(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        String[] titles = {"titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede"};


        HashSet<Libro> data = DataManager.getInstance().getData();

        String[][] dataTabla = new String[1][4];

        String[] response = null;

        response = BuscarEditarUI.getresponse();
        dataTabla[0] = response;

        TableModel tableModel = new DefaultTableModel(dataTabla, titles);

        JTable table = new JTable(tableModel);
        mainTableConatiner.setLayout(new BorderLayout());
        mainTableConatiner.add(new JScrollPane(table), BorderLayout.CENTER);

        mainTableConatiner.add(table.getTableHeader(), BorderLayout.NORTH);

        mainTableConatiner.setVisible(true);
        mainTableConatiner.setSize(10, 10);
        table.getDefaultEditor(String.class).addCellEditorListener(this);


        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (change) {
                    Libro origin = BuscarEditarUI.getbuscar();

                    String nombre = table.getModel().getValueAt(0, 0).toString();
                    String autor = table.getModel().getValueAt(0, 1).toString();
                    Integer anio = Integer.valueOf(table.getModel().getValueAt(0, 2).toString());
                    Integer estante_numero = Integer.valueOf(table.getModel().getValueAt(0, 3).toString());
                    String estante_seccion = table.getModel().getValueAt(0, 4).toString();
                    Integer piso = Integer.valueOf(table.getModel().getValueAt(0, 5).toString());
                    String edificio = table.getModel().getValueAt(0, 6).toString();
                    String sede = table.getModel().getValueAt(0, 7).toString();
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
                    Data_adder.overwrite(origin, agregar);
                    dispose();
                }
            }
        });

    }
    @Override
    public void editingStopped(ChangeEvent e) {
        change=true;
    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }
}