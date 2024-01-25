/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Pelicula;
import entidades.Protagonista;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;

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
        Pelicula peliculaOb = new Pelicula();
        Session sesion = peliculaOb.crearSesion();
        List<Pelicula> listaPelicula = peliculaOb.consultar(sesion);
        ObservableList<String> listaStringPelicula = FXCollections.observableArrayList();
        for (Pelicula pelicula : listaPelicula) {
            listaStringPelicula.add(pelicula.getTitulo());
        }
        comboPelicula.setItems(listaStringPelicula);
        if (App.getAccion() == "actualizar") {
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
    void insertar(ActionEvent event) {
        String peliculaString = comboPelicula.getValue();
        String protagonistaString = fieldProtagonista.getText();
        comboPelicula.setValue("");
        fieldProtagonista.clear();
        Pelicula pelicula = new Pelicula();
        Session session = pelicula.crearSesion();
        pelicula = pelicula.consultarId(session, peliculaString);
        Protagonista protagonista = new Protagonista(protagonistaString, pelicula);
        protagonista.crearSesion();
        if (App.getAccion() == "añadir") {
            protagonista.insertar(session, pelicula);
        } else {
            protagonista.actualizar(session, pelicula);
        }
    }
}
