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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "Protagonista")
public class Protagonista extends AccionesGenerico {

    public Protagonista() {
    }

    public Protagonista(String nombre, Pelicula pelicula) {
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
    public List<Protagonista> consultar(Session session) {
        String consulta = "FROM Protagonista";
        Query query = session.createQuery(consulta);
        List<Protagonista> lista = query.list();
        return lista;
    }

    public Protagonista consultarId(Session session, String id) {
        Protagonista protagonista = session.get(Protagonista.class, id);
        return protagonista;
    }

    public List<Object[]> devolverPeliculaCineProta(Session sesion, String protagonista) {
        String hql = "SELECT p, c FROM Pelicula p " +
                 "JOIN Funcion f ON f.idPelicula = p " +
                 "JOIN Cine c ON f.idCine = c " +
                 "WHERE p IN (SELECT pr.pelicula FROM Protagonista pr WHERE pr.nombre = :nombreProtagonista)";
        Query<Object[]> query = sesion.createQuery(hql, Object[].class);
        query.setParameter("nombreProtagonista", protagonista);
        List<Object[]> resultados = query.list();
        query.setParameter("nombreProtagonista", protagonista);
        return resultados;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nPelicula: " + pelicula.getTitulo() + "\n";
    }
}
