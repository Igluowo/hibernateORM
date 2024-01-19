/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.hibernateproyecto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.mapping.Set;

/**
 *
 * @author 2damb
 */

@Entity
@Table(name = "Cine")
public class Cine {
    @Id
    String nombre;
    
    @Column(name = "Calle")
    String calle;
    
    @Column(name = "Número")
    String numero;
    
    @Column(name = "Teléfono")
    String telefono;
    
    @OneToMany(mappedBy = "Tarifa")
    Set<Tarifa> listaTarifas;
    
}
