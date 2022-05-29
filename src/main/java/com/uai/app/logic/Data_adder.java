package com.uai.app.logic;

import com.uai.app.dominio.Libro;

import java.util.HashSet;

public class Data_adder {



    public static void agregarLibro(Libro p) {
        HashSet <Libro> nuevo=DataManager.getInstance().getData();
        nuevo.add(p);
        DataManager.getInstance().setData(nuevo);
}

    public static void agregarSede(Libro p) {
        HashSet <String> NEW=DataManager.getInstance().getSedeTEMP();
        NEW.add(p.getSede());
        DataManager.getInstance().setSedeTEMP(NEW);
    }

    public static void overwrite(Libro origin, Libro nuevo) {
        Data_remover.removerLibro(origin);
        agregarLibro(nuevo);
        System.out.println("Se han realizado los cambios");
    }
}
