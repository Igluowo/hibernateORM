/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Cine;
import entidades.Pelicula;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;

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
            Session sesion = cine.crearSesion();
            if (App.getAccion() == "añadir") {
                cine.insertar(sesion, cine);
            }else{
                cine.actualizar(sesion, cine);
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
            Session sesion = pelicula.crearSesion();
            if (App.getAccion() == "añadir") {
                pelicula.insertar(sesion, pelicula);
            }else{
                pelicula.actualizar(sesion, pelicula);
            }
        }
    }

}
