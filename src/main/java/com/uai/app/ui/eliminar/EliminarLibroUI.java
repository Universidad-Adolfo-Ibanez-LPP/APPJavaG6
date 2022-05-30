package com.uai.app.ui.eliminar;
import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_remover;
import com.uai.app.logic.SearchManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.exceptions.LibroNoEncontradoUI;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarLibroUI extends UAIJFrame{
    private JPanel mainPanel;

    private JButton ConfirmarButton;
    private JTextField textField1;
    private JScrollPane Jscroll;
    private JTextArea textArea1;


    public EliminarLibroUI(String title) throws DataNotLoadedException {
        super(title);
        this.setMainPanel(mainPanel);

        String tituloss= DataManager.getInstance().getTitulos();
        textArea1.setText(tituloss);

            ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer aux;
                    String eleccion_prev = textField1.getText();
                    String eleccion = SearchManager.getInstance().busquedaTitulo(eleccion_prev);
                    LibroBuilder builder = new LibroBuilder();
                    builder.withTitulo(eleccion);
                    Libro eliminar = builder.build();
                    aux = Data_remover.removerLibro(eliminar);
                    if (aux == 1) {
                        dispose();
                        UIBuilder.buildUI(EliminarOkUI.class);

                    }
                } catch (NullPointerException | BookNotFoundException ex) {
                    System.err.println("No se encontro el libro a eliminar");
                    UIBuilder.buildUI(LibroNoEncontradoUI.class);

                }
            }
        });




    }
}

