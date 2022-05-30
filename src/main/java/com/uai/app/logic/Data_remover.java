package com.uai.app.logic;

import com.uai.app.dominio.Libro;

import java.util.HashSet;

public class Data_remover {
    
    static public Integer removerLibro(Libro p) {
        HashSet<Libro> data=DataManager.getInstance().getData();
        Libro index = null;
        Integer num = 0;
     for (Libro s : data) {
         if (s.compareTo(p) == 0) {
             index = s;
             num = 1;
         }
     }
        data.remove(index);
        DataManager.getInstance().setData(data);
        return num;
}
    static public Integer removerSede(Libro p) {
        HashSet<String> data=DataManager.getInstance().getSedeTEMP();
        String index = null;
        String Sedeb=p.getSede();
        Integer num = 0;
        for (String s: data) {
            if (s.compareTo(Sedeb) == 0) {
                index = s;
                num = 1;
            }
        }
        data.remove(index);
        DataManager.getInstance().setSedeTEMP(data);
        return num;
    }
    static public Integer removerPiso(Libro p) {
        HashSet<Integer> data=DataManager.getInstance().getPisoTEMP();
        Integer index = null;
        Integer Pisob=p.getPiso();
        Integer num = 0;
        for (Integer s: data) {
            if (s.compareTo(Pisob) == 0) {
                 index = s;
                num = 1;
            }
        }
        data.remove(index);
        DataManager.getInstance().setPisoTEMP(data);
        return num;
    }
    static public Integer removerSeccion(Libro p) {
        HashSet<String> data=DataManager.getInstance().getSeccionTEMP();
        String index = null;
        String Seccionb=p.getEstante_seccion();
        Integer num = 0;
        for (String s: data) {
            if (s.compareTo(Seccionb) == 0) {
                index = s;
                num = 1;
            }
        }
        data.remove(index);
        DataManager.getInstance().setSeccionTEMP(data);
        return num;
    }

}
