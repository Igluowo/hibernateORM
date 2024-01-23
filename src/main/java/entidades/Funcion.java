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
import java.time.LocalTime;
import org.hibernate.Session;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "Función")
public class Funcion extends AccionesGenerico {

    public Funcion(Pelicula idPelicula, Cine idCine, LocalTime hora) {
        this.idPelicula = idPelicula;
        this.idCine = idCine;
        this.hora = hora;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Pelicula", nullable = true)
    private Pelicula idPelicula;

    @ManyToOne
    @JoinColumn(name = "Cine")
    Cine idCine;

    @Column(name = "Hora")
    private LocalTime hora;

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Cine getCine() {
        return idCine;
    }

    public void setCine(Cine idCine) {
        this.idCine = idCine;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public Object consultar(Session session, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
