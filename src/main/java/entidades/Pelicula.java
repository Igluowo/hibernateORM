/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "Pelicula")
public class Pelicula extends AccionesGenerico {

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, String clasificacion, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    @Id
    private String titulo;

    @Column(name = "Director")
    private String director;

    @Column(name = "Clasificación")
    private String clasificacion;

    @Column(name = "Género")
    private String genero;

    @OneToMany(mappedBy = "idPelicula", cascade = CascadeType.ALL)
    private Set<Funcion> listaFunciones;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    //@Size(max = 3)
    private Set<Protagonista> protagonistas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Funcion> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(Set<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public Set<Protagonista> getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(Set<Protagonista> protagonistas) {
        this.protagonistas = protagonistas;
    }

    @Override
    public List<Pelicula> consultar(Session session) {
        String consulta = "FROM Pelicula";
        Query query = session.createQuery(consulta);
        List<Pelicula> lista = query.list();
        return lista;
    }

    public Pelicula consultarId(Session session, String id) {
        Pelicula pelicula = session.get(Pelicula.class, id);
        return pelicula;
    }

    public List<Pelicula> consultarPeliculasCine(Session sesion, String cine) {
        String consulta = "Select f.idPelicula From Funcion as f where f.idCine = :cineId";
        Query query = sesion.createQuery(consulta, Pelicula.class);
        query.setParameter("cineId", cine);
        List<Pelicula> lista = query.list();
        return lista;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + titulo + "\nDirector: " + director + "\nClasificacion: " + clasificacion
                + "\nTeléfono: " + genero + "\n";
    }
}
