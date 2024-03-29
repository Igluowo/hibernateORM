/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import entidades.Cine;
import entidades.Pelicula;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import proyecto.hibernateproyecto.App;
import repositorio.CineRepositorio;
import repositorio.PeliculaRepositorio;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class PantallaCineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button botonInsertar;

    @FXML
    private Label etiquetaDireccion;

    @FXML
    private Label etiquetaNombre;

    @FXML
    private Label etiquetaNumero;

    @FXML
    private Label etiquetaTelefono;

    @FXML
    private TextField fieldDireccion;

    @FXML
    private TextField fieldNombre;

    @FXML
    private TextField fieldNumero;

    @FXML
    private TextField fieldTelefono;

    @FXML
    private Label tituloVentana;
    
    CineRepositorio cineRepo = new CineRepositorio();
    
    PeliculaRepositorio peliculaRepo = new PeliculaRepositorio();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (App.getAccion() == "actualizar") {
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Cine");
        }
        if (!App.isCine()) {
            etiquetaNombre.setText("Título");
            etiquetaDireccion.setText("Director");
            etiquetaNumero.setText("Clasificación");
            etiquetaTelefono.setText("Género");
            if (App.getAccion() == "actualizar") {
                tituloVentana.setText("Actualizar a la tabla película");
            } else {
                tituloVentana.setText("Insertar a la tabla película");
            }
        }
    }

    @FXML
    void insertar(ActionEvent event) {
        if (App.isCine()) {
            String nombre = fieldNombre.getText();
            String direccion = fieldDireccion.getText();
            String numero = fieldNumero.getText();
            String telefono = fieldTelefono.getText();
            fieldNombre.clear();
            fieldDireccion.clear();
            fieldNumero.clear();
            fieldTelefono.clear();
            Cine cine = new Cine(nombre, direccion, numero, telefono);
            Session sesion = cineRepo.crearSesion();
            if (App.getAccion() == "añadir") {
                cineRepo.insertar(sesion, cine);
            } else {
                cineRepo.actualizar(sesion, cine);
            }
        } else {
            String titulo = fieldNombre.getText();
            String director = fieldDireccion.getText();
            String clasificacion = fieldNumero.getText();
            String genero = fieldTelefono.getText();
            fieldNombre.clear();
            fieldDireccion.clear();
            fieldNumero.clear();
            fieldTelefono.clear();
            Pelicula pelicula = new Pelicula(titulo, director, clasificacion, genero);
            Session sesion = peliculaRepo.crearSesion();
            if (App.getAccion() == "añadir") {
                peliculaRepo.insertar(sesion, pelicula);
            } else {
                peliculaRepo.actualizar(sesion, pelicula);
            }
        }
    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader escena = new FXMLLoader(App.class.getResource("SeleccionarInsertar.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
