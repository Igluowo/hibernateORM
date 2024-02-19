/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Protagonista;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author erick
 */
public class ProtagonistaRepositorio extends AccionesGenerico{

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
        String hql = "SELECT p, c FROM Pelicula p "
                + "JOIN Funcion f ON f.idPelicula = p "
                + "JOIN Cine c ON f.idCine = c "
                + "WHERE p IN (SELECT pr.pelicula FROM Protagonista pr WHERE pr.nombre = :nombreProtagonista)";
        Query<Object[]> query = sesion.createQuery(hql, Object[].class);
        query.setParameter("nombreProtagonista", protagonista);
        List<Object[]> resultados = query.list();
        query.setParameter("nombreProtagonista", protagonista);
        return resultados;
    }
}
