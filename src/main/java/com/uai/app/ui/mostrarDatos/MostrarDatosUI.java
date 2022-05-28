package com.uai.app.ui.mostrarDatos;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.HashSet;

public class MostrarDatosUI extends UAIJFrame {

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextArea textArea1;

    public MostrarDatosUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String[] titles = { "titulo", "autor", "anio", "estante_numero", "estante_seccion", "piso", "edificio",
                "sede" };
        // obtengo los libros en una matriz
        //List<Libro> data = DataManager.getInstance().getData();
        HashSet<Libro> data = DataManager.getInstance().getData();
        
        String[][] dataTabla = new String[data.size()][4];
        int cont = 0;
        for (Libro p : data) {
            dataTabla[cont] = p.getDataToCsv();
            cont++;
        }

        TableModel tableModel = new DefaultTableModel(dataTabla, titles);
        JTable table = new JTable(tableModel);
        mainTableConatiner.setLayout(new BorderLayout());
        mainTableConatiner.add(new JScrollPane(table), BorderLayout.CENTER);

        mainTableConatiner.add(table.getTableHeader(), BorderLayout.NORTH);

        mainTableConatiner.setVisible(true);
        mainTableConatiner.setSize(400, 400);
    }

}
