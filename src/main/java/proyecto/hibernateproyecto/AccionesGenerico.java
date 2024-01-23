/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.hibernateproyecto;

import org.hibernate.Session;

/**
 *
 * @author erick
 */
public abstract class AccionesGenerico<T> {

    public void insertar(Session sesion, T objeto) {
        sesion.persist(objeto);
    }

    public void eliminar(Session sesion, T objeto) {
        sesion.delete(objeto);
    }

    public void modificar(Session sesion, T objeto) {
        sesion.merge(objeto);
    }

    public abstract T consultar(Session sesion, String id);
}
