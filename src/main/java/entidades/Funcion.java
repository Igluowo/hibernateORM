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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.annotations.CascadeType;
import org.hibernate.query.Query;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "Función")
public class Funcion extends AccionesGenerico {

    public Funcion() {
    }

    public Funcion(Pelicula idPelicula, Cine idCine, String hora) {
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
    private String hora;

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public List<Funcion> consultar(Session session) {
        String consulta = "FROM Funcion";
        Query query = session.createQuery(consulta);
        List<Funcion> lista = query.list();
        return lista;
    }

    public Funcion consultarId(Session session, String id) {
        Funcion funcion = session.get(Funcion.class, id);
        return funcion;
    }

    @Override
    public String toString() {
        return "\nCine: " + idCine.getNombre() + "\nPelícula: " + idPelicula.getTitulo() +
                "\nHora: " + hora + "\n";
    }
}
