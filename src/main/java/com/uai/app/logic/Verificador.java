package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.LibroAsociadoException;

import java.util.HashSet;

public class Verificador {
    public static void Verificarsede(Libro p) throws LibroAsociadoException {
        String psede = p.getSede();
        HashSet<Libro> data = DataManager.getInstance().getData();
        for (Libro S : data) {
            String Ssede = S.getSede();
            if (psede.equals(Ssede) == true) {
                throw new LibroAsociadoException();
            }
        }
    }
    public static void Verificarpiso(Libro p) throws LibroAsociadoException {
        Integer ppiso = p.getPiso();
        HashSet<Libro> data = DataManager.getInstance().getData();
        for (Libro S : data) {
            Integer Spiso = S.getPiso();
            if (ppiso==(Spiso)) {
                throw new LibroAsociadoException();
            }
        }
    }
    public static void Verificarseccion(Libro p) throws LibroAsociadoException {
        String pseccion = p.getEstante_seccion();
        HashSet<Libro> data = DataManager.getInstance().getData();
        for (Libro S : data) {
            String Sseccion = S.getEstante_seccion();
            if (pseccion.equals(Sseccion) == true) {
                throw new LibroAsociadoException();
            }
        }
    }

}
