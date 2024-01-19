/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class PantallaPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
        final SessionFactory sessionFactory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        final Session sesion = sessionFactory.openSession();
    }
}
