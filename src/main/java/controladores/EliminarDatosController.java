/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import entidades.Cine;
import entidades.Funcion;
import entidades.Pelicula;
import entidades.Protagonista;
import entidades.Tarifa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import proyecto.hibernateproyecto.App;
import repositorio.CineRepositorio;
import repositorio.FuncionRepositorio;
import repositorio.PeliculaRepositorio;
import repositorio.ProtagonistaRepositorio;
import repositorio.TarifaRepositorio;

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

    CineRepositorio cine = new CineRepositorio();

    PeliculaRepositorio pelicula = new PeliculaRepositorio();

    FuncionRepositorio funcion = new FuncionRepositorio();

    ProtagonistaRepositorio protagonista = new ProtagonistaRepositorio();

    TarifaRepositorio tarifa = new TarifaRepositorio();

    @FXML
    void eliminar(ActionEvent event) {
        String tabla = comboTabla.getValue();
        String id = fieldId.getText();
        comboTabla.setValue("");
        fieldId.clear();
        switch (tabla) {
            case "Cine":
                Session sesionCine = cine.crearSesion();
                Cine cineObj = cine.consultarId(sesionCine, id);
                cine.eliminar(sesionCine, cineObj);
                break;
            case "Pelicula":
                Session sesionPelicula = pelicula.crearSesion();
                Pelicula peliculaObj = pelicula.consultarId(sesionPelicula, id);
                pelicula.eliminar(sesionPelicula, peliculaObj);
                break;
            case "Protagonista":
                Session sesionProtagonista = protagonista.crearSesion();
                Protagonista protagonistaObj = protagonista.consultarId(sesionProtagonista, id);
                protagonista.eliminar(sesionProtagonista, protagonistaObj);
                break;
            case "Funcion":
                Session sesionFuncion = funcion.crearSesion();
                Funcion funcionObj = funcion.consultarId(sesionFuncion, id);
                funcion.eliminar(sesionFuncion, funcionObj);
                break;
            case "Tarifa":
                Session sesionTarifa = tarifa.crearSesion();
                Tarifa tarifaObj = tarifa.consultarId(sesionTarifa, id);
                tarifa.eliminar(sesionTarifa, tarifaObj);
                break;
        }
    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader escena = new FXMLLoader(App.class.getResource("PantallaPrincipal.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
