/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Cine;
import entidades.Pelicula;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author erick
 */
public class PeliculaRepositorio extends AccionesGenerico {

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

    public List<Pelicula> consultarPeliculasCine(Session sesion, Cine cine) {
        String consulta = "Select f.idPelicula From Funcion as f where f.idCine = :cineId";
        Query query = sesion.createQuery(consulta, Pelicula.class);
        query.setParameter("cineId", cine);
        List<Pelicula> lista = query.list();
        return lista;
    }
}
