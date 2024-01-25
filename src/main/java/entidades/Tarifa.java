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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author 2damb
 */
@Entity
@Table(name = "Tarifa")
public class Tarifa extends AccionesGenerico {

    public Tarifa() {
    }

    public Tarifa(String dia, double precio, Cine cine) {
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
    private double precio;

    @ManyToOne
    @JoinColumn(name = "IdCine")
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    @Override
    public List<Tarifa> consultar(Session session) {
        String consulta = "FROM Tarifa";
        Query query = session.createQuery(consulta);
        List<Tarifa> lista = query.list();
        return lista;
    }

    public Tarifa consultarId(Session session, String id) {
        Tarifa tarifa = session.get(Tarifa.class, id);
        return tarifa;
    }

    @Override
    public String toString() {
        return "\nCine: " + cine.getNombre() + "\nDia: " + dia + "\nPrecio: " + precio + "\n";
    }
}