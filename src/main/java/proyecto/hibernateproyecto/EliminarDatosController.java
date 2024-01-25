/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Cine;
import entidades.Funcion;
import entidades.Pelicula;
import entidades.Protagonista;
import entidades.Tarifa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EliminarDatosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> listaTablas = FXCollections.observableArrayList();
        listaTablas.add("Cine");
        listaTablas.add("Pelicula");
        listaTablas.add("Funcion");
        listaTablas.add("Tarifa");
        listaTablas.add("Protagonista");
        comboTabla.setItems(listaTablas);
    }

    @FXML
    private Button botonEliminar;

    @FXML
    private ComboBox<String> comboTabla;

    @FXML
    private TextField fieldId;

    @FXML
    void eliminar(ActionEvent event) {
        String tabla = comboTabla.getValue();
        String id = fieldId.getText();
        comboTabla.setValue("");
        fieldId.clear();
        switch (tabla) {
            case "Cine":
                Cine cine = new Cine();
                Session sesionCine = cine.crearSesion();
                Cine cineObj = cine.consultarId(sesionCine, id);
                cineObj.eliminar(sesionCine, cineObj);
                break;
            case "Pelicula":
                Pelicula pelicula = new Pelicula();
                Session sesionPelicula = pelicula.crearSesion();
                Pelicula peliculaObj = pelicula.consultarId(sesionPelicula, id);
                peliculaObj.eliminar(sesionPelicula, peliculaObj);
                break;
            case "Protagonista":
                Protagonista protagonista = new Protagonista();
                Session sesionProtagonista = protagonista.crearSesion();
                Protagonista protagonistaObj = protagonista.consultarId(sesionProtagonista, id);
                protagonista.eliminar(sesionProtagonista, protagonistaObj);
                break;
            case "Funcion":
                Funcion funcion = new Funcion();
                Session sesionFuncion = funcion.crearSesion();
                Funcion funcionObj = funcion.consultarId(sesionFuncion, id);
                funcionObj.eliminar(sesionFuncion, funcionObj);
                break;
            case "Tarifa":
                Tarifa tarifa = new Tarifa();
                Session sesionTarifa = tarifa.crearSesion();
                Tarifa tarifaObj = tarifa.consultarId(sesionTarifa, id);
                tarifaObj.eliminar(sesionTarifa, tarifaObj);
                break;
        }
    }

}
