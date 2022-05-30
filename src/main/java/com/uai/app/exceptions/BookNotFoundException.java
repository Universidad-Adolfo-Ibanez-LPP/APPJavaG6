package com.uai.app.exceptions;

public class BookNotFoundException extends Exception{

    public BookNotFoundException() {
        super("Libro no encontrado!");
    }

}
