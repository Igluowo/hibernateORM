/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Cine;
import entidades.Funcion;
import entidades.Pelicula;
import entidades.Tarifa;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
    private Parent root;
    private Stage escena;
    private Scene scene;


    @FXML
    private Button actualizarDatos;

    @FXML
    private Button aniadirDatos;

    @FXML
    private Button eliminarDatos;

    @FXML
    private Button visualizarDatos;

    public PantallaPrincipalController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //sesion.beginTransaction();
        Cine cine = new Cine("Yelmito", "4 de Mayo", "23", "933123456");
        Pelicula pelicula = new Pelicula("El resplandor", "Pepito Perez", "C", "Terror");
        LocalTime hora = LocalTime.of(12, 12, 12);
        Funcion funcion = new Funcion(pelicula, cine, hora);
        Cine cine2 = new Cine("Yelmitoito", "4 de Mayo", "23", "933123456");
        Tarifa tarifa = new Tarifa("Lunes", 4.70, cine);
    }

    @FXML
    void cambiarVentana(ActionEvent event) throws IOException {
        String ventana = "";
        if (event.getSource() == visualizarDatos) {
            ventana = "VisualizarDatos.fxml";
        } else if (event.getSource() == eliminarDatos) {
            ventana = "EliminarDatos.fxml";
        } else if (event.getSource() == aniadirDatos) {
            ventana = "SeleccionarInsertar.fxml";
            App.setAccion("añadir");
        } else {
            ventana = "SeleccionarInsertar.fxml";
            App.setAccion("actualizar");
        }
        FXMLLoader escenaFMXL = new FXMLLoader(App.class.getResource(ventana));
        root = escenaFMXL.load();
        scene = new Scene(root);
        escena = new Stage();
        escena.setScene(scene);
        escena.show();
    }

}
