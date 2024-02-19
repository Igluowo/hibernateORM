/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "Protagonista")
public class Protagonista {

    public Protagonista() {
    }

    public Protagonista(String nombre, Pelicula pelicula) {
        this.nombre = nombre;
        this.pelicula = pelicula;
    }

    public Protagonista(int id, String nombre, Pelicula pelicula) {
        this.id = id;
        this.nombre = nombre;
        this.pelicula = pelicula;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @ManyToOne
    private Pelicula pelicula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nNombre: " + nombre + "\nPelicula: " + pelicula.getTitulo() + "\n";
    }
}
