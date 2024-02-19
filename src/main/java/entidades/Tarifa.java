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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 *
 * @author 2damb
 */
@Entity
@Table(name = "Tarifa")
public class Tarifa {

    public Tarifa() {
    }

    public Tarifa(String dia, String precio, Cine cine) {
        this.dia = dia;
        this.precio = precio;
        this.cine = cine;
    }

    public Tarifa(int id, String dia, String precio, Cine cine) {
        this.id = id;
        this.dia = dia;
        this.precio = precio;
        this.cine = cine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Día")
    private String dia;

    @Column(name = "Precio")
    private String precio;

    @ManyToOne
    @JoinColumn(name = "idCine")
    private Cine cine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nCine: " + cine.getNombre() + "\nDia: " + dia + "\nPrecio: " + precio + "\n";
    }
}
