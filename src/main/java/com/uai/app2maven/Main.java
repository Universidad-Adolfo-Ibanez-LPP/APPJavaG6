package com.uai.app2maven;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.uai.app2maven.gestion.Libro;
import com.uai.app2maven.logic.Archivo;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {


        Archivo archivo = new Archivo(args[0]); //Instanciamos un nuevo archivo y lo llamamos archivo. Pasamos como argumento el csv
        List<Libro> lectura = archivo.leer(); //lectura crea una lista de todos los libros dentro del csv
        lectura.add(new Libro("hola","si",2009,12,"nose",2,"wena","sede"));
        archivo.guardar(lectura);







    }
}
