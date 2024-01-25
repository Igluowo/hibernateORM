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
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class VisualizarDatosController implements Initializable {

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

    private String resultado = "-----------------------";

    @FXML
    private TextArea areaResultado;

    @FXML
    private Button botonVisualizar;

    @FXML
    private Button botonVolver;

    @FXML
    private ComboBox<String> comboTabla;

    @FXML
    void visualizar(ActionEvent event) {
        String tabla = comboTabla.getValue();
        switch (tabla) {
            case "Cine":
                Cine cine = new Cine();
                Session sesionCine = cine.crearSesion();
                List<Cine> listaCine = cine.consultar(sesionCine);
                for (Cine cineElemento : listaCine) {
                    cineElemento.toString();
                    resultado += cineElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Pelicula":
                Pelicula pelicula = new Pelicula();
                Session sesionPelicula = pelicula.crearSesion();
                List<Pelicula> listaPelicula = pelicula.consultar(sesionPelicula);
                for (Pelicula peliculaElemento : listaPelicula) {
                    peliculaElemento.toString();
                    resultado += peliculaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Protagonista":
                Protagonista protagonista = new Protagonista();
                Session sesionProtagonista = protagonista.crearSesion();
                List<Protagonista> listaProtagonista = protagonista.consultar(sesionProtagonista);
                for (Protagonista protagonistaElemento : listaProtagonista) {
                    protagonistaElemento.toString();
                    resultado += protagonistaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Funcion":
                Funcion funcion = new Funcion();
                Session sesionFuncion = funcion.crearSesion();
                List<Funcion> listaFuncion = funcion.consultar(sesionFuncion);
                for (Funcion funcionElemento : listaFuncion) {
                    funcionElemento.toString();
                    resultado += funcionElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Tarifa":
                Tarifa tarifa = new Tarifa();
                Session sesionTarifa = tarifa.crearSesion();
                List<Tarifa> listaTarifa = tarifa.consultar(sesionTarifa);
                for (Tarifa tarifaElemento : listaTarifa) {
                    resultado += tarifaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
        }
        areaResultado.setText(resultado);
        resultado = "-----------------------";
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
