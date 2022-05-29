package com.uai.app;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.CSVNotFoundException;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.files.FileManager;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UIBuilder;
import com.uai.app.ui.MainMenuUI;

import java.io.*;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

    private static FileManager fileManager;

    public static void main( String[] args ) throws IOException {
        System.out.println("COMENZANDO");
        String fileName = args[0];
        System.out.println(fileName);

        try {
            // statements

            //instancio el file manager
            fileManager = new FileManager(fileName);
            //instancio y seteo la data
            DataManager.getInstance().setData(fileManager.getData());
            DataManager.getInstance().setDatatemp(fileManager.getData());
            //aca ya puedo llamar al menu
            UIBuilder.buildMainUI(MainMenuUI.class);
            DataManager.getInstance().getDataAsString();
            // Map a = DataManager.getInstance().getPeopleByColum(Tittles.PISO);
            //finalizo guardando la data



        } catch (CSVNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (DataNotLoadedException e) {
            e.printStackTrace();
        }

    }
    public static void saveData() {
        fileManager.saveData();
    }
}
