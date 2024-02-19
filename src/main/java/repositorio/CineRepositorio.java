/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Cine;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author erick
 */
public class CineRepositorio extends AccionesGenerico {

    @Override
    public List<Cine> consultar(Session session) {
        String consulta = "FROM Cine";
        Query query = session.createQuery(consulta, Cine.class);
        List<Cine> lista = query.list();
        return lista;
    }

    public Cine consultarId(Session session, String id) {
        Cine cine = session.get(Cine.class, id);
        System.out.println("Returning " + cine.getNombre());
        return cine;
    }

    public List<Cine> devolverCineProtas(Session sesion, String protagonista) {
        String hql = "SELECT DISTINCT c FROM Cine c "
                + "JOIN c.listaFunciones f "
                + "JOIN f.idPelicula p "
                + "JOIN p.protagonistas pr "
                + "WHERE pr.nombre = :nombreProtagonista";
        Query<Cine> query = sesion.createQuery(hql, Cine.class);
        query.setParameter("nombreProtagonista", protagonista);
        List<Cine> cines = query.list();
        return cines;
    }
}
