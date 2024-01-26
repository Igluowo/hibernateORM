/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Cine;
import entidades.Funcion;
import entidades.Pelicula;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class InsertarFuncionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Cine cineOb = new Cine();
        Session sesion = cineOb.crearSesion();
        List<Cine> listaCine = cineOb.consultar(sesion);
        ObservableList<String> listaString = FXCollections.observableArrayList();
        for (Cine cine : listaCine) {
            listaString.add(cine.getNombre());
        }
        comboCine.setItems(listaString);
        Pelicula peliculaOb = new Pelicula();
        sesion = peliculaOb.crearSesion();
        List<Pelicula> listaPelicula = peliculaOb.consultar(sesion);
        ObservableList<String> listaStringPelicula = FXCollections.observableArrayList();
        for (Pelicula pelicula : listaPelicula) {
            listaStringPelicula.add(pelicula.getTitulo());
        }
        comboPelicula.setItems(listaStringPelicula);
        if (App.getAccion() == "actualizar") {
            botonInsertar.setText("Actualizar");
            titulo.setText("Actualizar la tabla Función");
        }
    }

    @FXML
    private Button botonInsertar;

    @FXML
    private Label titulo;

    @FXML
    private ComboBox<String> comboCine;

    @FXML
    private ComboBox<String> comboPelicula;

    @FXML
    private TextField fieldHora;

    @FXML
    void insertar(ActionEvent event) {
        String cine = comboCine.getValue();
        String pelicula = comboPelicula.getValue();
        String hora = fieldHora.getText();
        comboCine.setValue("");
        comboPelicula.setValue("");
        fieldHora.clear();
        Cine cineOb = new Cine();
        Pelicula peliculaOb = new Pelicula();
        Session sesion = cineOb.crearSesion();
        Cine cineFun = cineOb.consultarId(sesion, cine);
        sesion = peliculaOb.crearSesion();
        Pelicula peliculaFun = peliculaOb.consultarId(sesion, pelicula);
        Funcion funcion = new Funcion(peliculaFun, cineFun, hora);
        sesion = funcion.crearSesion();
        if (App.getAccion() == "añadir") {
            funcion.insertar(sesion, funcion);
        } else {
            funcion.actualizar(sesion, funcion);
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
