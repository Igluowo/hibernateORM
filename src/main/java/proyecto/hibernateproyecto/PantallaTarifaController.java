/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import entidades.Cine;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class PantallaTarifaController implements Initializable {

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
        if (App.getAccion() == "actualizar") {
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Tarifa");
        }
    }

    @FXML
    private Button botonInsertar;

    @FXML
    private ComboBox<String> comboCine;

    @FXML
    private TextField fieldDia;

    @FXML
    private Spinner<?> fieldPrecio;

    @FXML
    private Label tituloVentana;

    @FXML
    void insertar(ActionEvent event) {
        String cineString = comboCine.getValue();
        String dia = fieldDia.getText();
        String precio = fieldPrecio.getValue().toString();
        Cine cineOb = new Cine();
        Session sesion = cineOb.crearSesion();
        Cine cine = cineOb.consultarId(sesion, cineString);
        Tarifa tarifa = new Tarifa();
        sesion = tarifa.crearSesion();
        tarifa.insertar(sesion, cine);
        if (App.getAccion() == "añadir") {
            tarifa.insertar(sesion, tarifa);
        } else {
            tarifa.actualizar(sesion, tarifa);
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
