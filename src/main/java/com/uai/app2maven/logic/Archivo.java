package com.uai.app2maven.logic;

import com.opencsv.bean.CsvToBeanBuilder;
import com.uai.app2maven.gestion.Libro;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;


public class Archivo {

    //Leer el csv
    //Guardar el csv

    String fileName;

    public Archivo(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Ya que cada archivo tiene un fileName, esta función lo usa para poder leer el csv.
     * Esta función crea una lista que contiene objetos de la clase libro
     */
    public List<Libro> leer() {
        System.out.println("COMENZANDO");

        List<Libro> beans = null;
        try {
            File f = new File(fileName);
            FileReader ff = new FileReader(f, Charset.forName("UTF-8"));
            beans = new CsvToBeanBuilder(ff)
                    .withType(Libro.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            System.err.println("No existe el archivo");
        } catch (IOException e) {
            System.err.println("No se puede leer el archivo");
        } catch (NoClassDefFoundError e) {
            System.out.println("AYUDA");
        }


//        Collections.sort(beans);

        for (Libro p : beans) {
            System.out.println(p);
        }
        return beans;
    }
    /**
     * Esta función guarda el csv y sus cambios.
     *
     *  @param beans ya que se pueden guardar cambios, beans es la lista de libros ya editada y lista para guardar
     */
    public void guardar(List<Libro> beans) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println("titulo,autor,anio,estante_numero,estante_seccion,piso,edificio,sede"); //Ponemos el header de vuelta

        for (Libro p : beans) { //añadimos cada libro en beans al csv, aprovechandonos de la funcion creada en Libro.java
            writer.println(p.toStringArray()); //Revisar toStringArray para entender bien que onda
        }
        writer.close();
    }




// Metodo expropiado de https://stackoverflow.com/questions/67741964/how-to-write-list-of-objects-in-a-csv-using-opencsv-csvwriter-in-java









}
