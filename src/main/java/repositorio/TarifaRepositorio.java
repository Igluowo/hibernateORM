/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Tarifa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author erick
 */
public class TarifaRepositorio extends AccionesGenerico {
    
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
}
