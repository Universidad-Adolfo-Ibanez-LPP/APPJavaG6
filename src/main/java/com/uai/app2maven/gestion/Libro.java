package com.uai.app2maven.gestion;

import com.opencsv.bean.CsvBindByName;

public class Libro implements Comparable<Libro>{

    /**
     * Este constructor es necesario porque si no Archivo.leer muere
     */
    public Libro() {
    }

    /**
     * Constructor para poder añadir un libro nuevo
     */
    public Libro(String titulo, String autor, int anio, int estante_numero, String estante_seccion, int piso, String edificio, String sede) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.estante_numero = estante_numero;
        this.estante_seccion = estante_seccion;
        this.piso = piso;
        this.edificio = edificio;
        this.sede = sede;
    }

    //titulo,autor,anio,estante_numero,estante_seccion,piso,edificio,sede
    @CsvBindByName(column = "titulo")
    private String titulo;

    @CsvBindByName(column = "autor")
    private String autor;

    @CsvBindByName(column = "anio")
    private int anio;

    @CsvBindByName(column = "estante_numero")
    private int estante_numero;

    @CsvBindByName(column = "estante_seccion")
    private String estante_seccion;

    @CsvBindByName(column = "piso")
    private int piso;

    @CsvBindByName(column = "edificio")
    private String edificio;

    @CsvBindByName(column = "sede")
    private String sede;


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public int getEstante_numero() {
        return estante_numero;
    }

    public String getEstante_seccion() {
        return estante_seccion;
    }

    public int getPiso() {
        return piso;
    }

    public String getEdificio() {
        return edificio;
    }

    public String getSede() {
        return sede;
    }

    /**
     * Esta función devuelve una string formada por las tres variables string de Libro entre comillas dobles
     * y la variable tipo int, separadas por comas.
     *
     * Esto permite la facil insercion al csv, ya que las comillas impiden la confusion las comas
     * dentro de las variables
     */
    public String toStringArray() {
        return '"'+titulo+'"'+","+'"'+autor+'"'+","+anio+","+estante_numero
                +","+'"'+estante_seccion+'"'+","+piso+","+'"'+edificio+'"'+","+'"'+sede+'"';
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", estante_numero=" + estante_numero +
                ", estante_seccion='" + estante_seccion + '\'' +
                ", piso=" + piso +
                ", edificio='" + edificio + '\'' +
                ", sede='" + sede + '\'' +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.getTitulo())*-1;
    }

}


