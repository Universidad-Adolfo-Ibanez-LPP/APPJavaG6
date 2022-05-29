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

}
