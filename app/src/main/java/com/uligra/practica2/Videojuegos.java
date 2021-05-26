package com.uligra.practica2;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Videojuegos {
    enum Consola{
        XBOX,
        PS5,
    }
    public String titulo;
    public String descripcion;
    public Consola plataforma;
    public Double precio;
    public String fecha;
    public int oferta;
    public int img;
    public Videojuegos(String titulo, String descripcion, Consola plataforma, Double precio, String fecha, int oferta, int img){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.plataforma = plataforma;
        this.precio = precio;
        this.fecha = fecha;
        this.oferta = oferta;
        this.img = img;
    }
    static public ArrayList<Videojuegos> videjuegos = new ArrayList<Videojuegos>();
}
