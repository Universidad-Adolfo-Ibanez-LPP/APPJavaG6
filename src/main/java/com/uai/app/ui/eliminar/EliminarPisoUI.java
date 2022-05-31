package com.uai.app.ui.eliminar;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.*;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.Data_remover;
import com.uai.app.logic.Verificador;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.cambiar.CambiarPisoUI;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EliminarPisoUI extends UAIJFrame{
    private JPanel mainPanel;
    private JScrollPane Jscroll;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton ConfirmarButton;


    public EliminarPisoUI(String title) throws DataNotLoadedException {
        super(title);
        this.setMainPanel(mainPanel);
        String tituloss= DataManager.getInstance().getPisoTEMPString();
        textArea1.setText(tituloss);
        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Integer aux;
                    String eleccion = textField1.getText();
                    Integer eleccion2 = Integer.valueOf(eleccion);
                    LibroBuilder builder = new LibroBuilder();
                    builder.withPiso(eleccion2);
                    Libro eliminar= builder.build();
                    Verificador.Verificarpiso(eliminar);
                    aux = Data_remover.removerPiso(eliminar);
                    if (aux == 1) {
                        dispose();
                        System.out.println("Se ha eliminado el piso: " + eleccion);
                        UIBuilder.buildUI(EliminarPisoUI.class);
                    }
                }
                catch (LibroAsociadoException ex) {
                    ex.printStackTrace();
                    UIBuilder.buildUI(EliminarNoOkUI.class);

                }
                catch (NumberFormatException ex) {
                    System.err.println("Colocaste un String en donde deberia ir un Int");
                    UIBuilder.buildUI(StringEnIntgerUI.class);

                }
                catch (PisoNotFoundException ex){
                    System.err.println("No se encontró el piso a eliminar");
                    UIBuilder.buildUI(PisoNotFoundOkUI.class);

                }
            }

        });

    }
}

