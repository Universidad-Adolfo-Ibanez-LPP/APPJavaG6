package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.ui.utils.*;
import org.apache.commons.text.CaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DataManager {

    private HashSet<Libro> data;
    private HashSet<String> sedeTEMP;
    private HashSet<Integer> pisoTEMP;
    private HashSet<String> seccionTEMP;

    private static DataManager instance;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
            SearchManager.getInstance();
        }
        return instance;
    }

    public HashSet<Libro> getData() {return data;}
    public HashSet<String> getSedeTEMP() {return sedeTEMP;}
    public HashSet<String> getSeccionTEMP() {return seccionTEMP;}
    public HashSet<Integer> getPisoTEMP() {return pisoTEMP;}

    public void setData(HashSet<Libro> data) {this.data = data;}
    public void setDatatemp(HashSet<Libro> dataa){
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        HashSet<Integer> set3 = new HashSet<Integer>();
        for (Libro p : dataa){
            String Newsede=p.getSede();
            int Newpiso=p.getPiso();
            String Newseccion=p.getEstante_seccion();

            set1.add(Newsede);
            set2.add(Newseccion);
            set3.add(Newpiso);
        }
        this.sedeTEMP=set1;
        this.seccionTEMP=set2;
        this.pisoTEMP=set3;

    }
    public void setSedeTEMP(HashSet<String> Sede) {sedeTEMP = Sede;}
    public void setSeccionTEMP(HashSet<String> Seccion) {seccionTEMP = Seccion;}
    public void setPisoTEMP(HashSet<Integer> Piso) {pisoTEMP = Piso;}

    public String getDataAsString() throws DataNotLoadedException {
        // verifico que la data exista y sino devuelvo excepcion
        if (AppUtils.isNull(data)) {
            throw new DataNotLoadedException();
        }
        // Creo un string para ir sumando ahi la data
        StringBuilder sb = new StringBuilder(data.size() * 50);
        for (Libro p : data) {
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getTitulos() {
        String aux=null;
        StringBuilder sb= new StringBuilder(data.size() * 50);
        for (Libro s : data) {
            aux = s.getTitulo();
            sb.append(aux);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getSedeTEMPString() {
        String aux=null;
        StringBuilder sb= new StringBuilder(sedeTEMP.size() * 50);
        for (String element :this.sedeTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getPisoTEMPString() {
        Integer aux=null;
        StringBuilder sb= new StringBuilder(pisoTEMP.size() * 50);
        for (Integer element :this.pisoTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getSeccionTEMPString() {
        String aux=null;
        StringBuilder sb= new StringBuilder(seccionTEMP.size() * 50);
        for (String element :this.seccionTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }
}
