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
    public static void agregarSeccion(Libro p) {
        HashSet <String> NEW=DataManager.getInstance().getSeccionTEMP();
        NEW.add(p.getEstante_seccion());
        DataManager.getInstance().setSeccionTEMP(NEW);
    }
    public static void agregarPiso(Libro p) {
        HashSet <Integer> NEW=DataManager.getInstance().getPisoTEMP();
        NEW.add(p.getPiso());
        DataManager.getInstance().setPisoTEMP(NEW);
    }

    public static void overwrite(Libro origin, Libro nuevo) {
        Data_remover.removerLibro(origin);
        agregarLibro(nuevo);
        System.out.println("Se han realizado los cambios");
    }
}
