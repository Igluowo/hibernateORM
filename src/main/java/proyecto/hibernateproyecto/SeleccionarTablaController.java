/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class SeleccionarTablaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Parent root;
    private Stage escena;
    private Scene scene;

    @FXML
    private Button botonCine;

    @FXML
    private Button botonFuncion;

    @FXML
    private Button botonPeliculas;

    @FXML
    private Button botonProtagonista;

    @FXML
    private Button botonTarifa;

    @FXML
    private Label etiquetaAccion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String accion = App.getAccion();
        etiquetaAccion.setText(accion);
        System.out.println(accion);
    }

    @FXML
    void cambiarVentana(ActionEvent event) throws IOException {
        String ventana = "";
        if (event.getSource() == botonCine) {
            ventana = "InsertarCine.fxml";
            App.setCine(true);
        } else if (event.getSource() == botonFuncion) {
            ventana = "InsertarFuncion.fxml";
        } else if (event.getSource() == botonPeliculas) {
            App.setCine(false);
            ventana = "InsertarCine.fxml";
        } else if (event.getSource() == botonProtagonista) {
            ventana = "InsertarProtagonista.fxml";
        } else {
            ventana = "InsertarTarifa.fxml";
        }
        FXMLLoader escenaFMXL = new FXMLLoader(App.class.getResource(ventana));
        root = escenaFMXL.load();
        scene = new Scene(root);
        escena = new Stage();
        escena.setScene(scene);
        escena.show();
    }

}
