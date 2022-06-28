package com.uai.app.dominio.enums;

public enum Tittles {

    TITULO("titulo"), AUTOR("autor"), ANIO("anio"), ESTANTE_NUMERO("estante_numero"),
    ESTANTE_SECCION("estante_seccion"),
    PISO("piso"), EDIFICIO("edificio"), SEDE("sede");

    // titulo,autor,anio,estante_numero,estante_seccion,piso,edificio,sede

    private String val;

    public String getVal() {
        return val;
    }

    Tittles(String val) {
        this.val = val;
    }

}
