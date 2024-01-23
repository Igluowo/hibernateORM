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
import java.util.Set;
import org.hibernate.Session;
import proyecto.hibernateproyecto.AccionesGenerico;

/**
 *
 * @author 2damb
 */
@Entity
@Table(name = "Cine")
public class Cine extends AccionesGenerico {
    
    public Cine() {}

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
    public Object consultar(Session session, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
