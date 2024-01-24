/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.hibernateproyecto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author erick
 */
public abstract class AccionesGenerico<T> {

    public Session crearSesion() {
        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
        final SessionFactory sessionFactory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        Session sesion = sessionFactory.openSession();
        return sesion;
    }

    public void insertar(Session sesion, T objeto) {
        sesion.beginTransaction();
        sesion.persist(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void eliminar(Session sesion, T objeto) {
        sesion.delete(objeto);
    }

    public void modificar(Session sesion, T objeto) {
        sesion.merge(objeto);
    }

    public abstract T consultar(Session sesion, String id);
}
