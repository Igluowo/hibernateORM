/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import entidades.Pelicula;
import entidades.Protagonista;
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
import proyecto.hibernateproyecto.App;
import repositorio.PeliculaRepositorio;
import repositorio.ProtagonistaRepositorio;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class PantallaProtagonistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session sesion = peliculaRepo.crearSesion();
        List<Pelicula> listaPelicula = peliculaRepo.consultar(sesion);
        ObservableList<String> listaStringPelicula = FXCollections.observableArrayList();
        for (Pelicula pelicula : listaPelicula) {
            listaStringPelicula.add(pelicula.getTitulo());
        }
        comboPelicula.setItems(listaStringPelicula);
        if (App.getAccion() == "actualizar") {
            labelId.setVisible(true);
            fieldId.setVisible(true);
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Protagonista");
        }
    }

    @FXML
    private Button botonInsertar;

    @FXML
    private ComboBox<String> comboPelicula;

    @FXML
    private TextField fieldProtagonista;

    @FXML
    private Label tituloVentana;

    @FXML
    private TextField fieldId;

    @FXML
    private Label labelId;

    PeliculaRepositorio peliculaRepo = new PeliculaRepositorio();

    ProtagonistaRepositorio protagonistaRepo = new ProtagonistaRepositorio();

    @FXML
    void insertar(ActionEvent event) {
        String peliculaString = comboPelicula.getValue();
        String protagonistaString = fieldProtagonista.getText();
        String id = fieldId.getText();
        comboPelicula.setValue("");
        fieldProtagonista.clear();
        fieldId.clear();
        Session session = peliculaRepo.crearSesion();
        Pelicula pelicula = peliculaRepo.consultarId(session, peliculaString);
        if (App.getAccion() == "añadir") {
            Protagonista protagonista = new Protagonista(protagonistaString, pelicula);
            protagonistaRepo.insertar(session, protagonista);
        } else {
            Protagonista protagonista = new Protagonista(Integer.parseInt(id), protagonistaString, pelicula);
            protagonistaRepo.actualizar(session, protagonista);
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
