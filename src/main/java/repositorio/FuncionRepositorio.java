/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Funcion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author erick
 */
public class FuncionRepositorio extends AccionesGenerico {

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
}
