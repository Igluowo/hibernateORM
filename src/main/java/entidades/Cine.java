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
 * @author 2damb
 */
@Entity
@Table(name = "Cine")
public class Cine extends AccionesGenerico {

    public Cine() {
    }

    public Cine(String nombre, String calle, String numero, String telefono) {
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.telefono = telefono;
    }

    @Id
    private String nombre;

    @Column(name = "Calle")
    private String calle;

    @Column(name = "Número")
    private String numero;

    @Column(name = "Teléfono")
    private String telefono;

    @OneToMany(mappedBy = "idCine", cascade = CascadeType.ALL)
    private Set<Funcion> listaFunciones;

    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tarifa> tarifas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Funcion> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaPeliculas(Set<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public Set<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(Set<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

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

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nCalle: " + calle + "\nNúmero: " + numero
                + "\nTeléfono: " + telefono + "\n";
    }
}
