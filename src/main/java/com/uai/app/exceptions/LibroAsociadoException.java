package com.uai.app.exceptions;

public class LibroAsociadoException extends Exception {
    public LibroAsociadoException(){super("No es posible eliminarlo pues tiene un libro asociado");}
}
