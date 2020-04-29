package com.example.examenpractico2;

public class Restaurantes {
    private String nomRest;
    private String desc;
    private String dircyTel;
    private int imagen;
    private int estrellas;

    public Restaurantes(String nomRest, String desc, String dircyTel, int imagen, int estrellas) {
        this.nomRest = nomRest;
        this.desc = desc;
        this.dircyTel = dircyTel;
        this.imagen = imagen;
        this.estrellas = estrellas;
    }

    public String getNomRest() {
        return nomRest;
    }

    public String getDesc() {
        return desc;
    }

    public String getDircyTel() {
        return dircyTel;
    }

    public int getImagen() {
        return imagen;
    }

    public int getEstrellas() {
        return estrellas;
    }
}
