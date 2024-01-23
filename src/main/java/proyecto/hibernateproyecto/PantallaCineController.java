/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.hibernateproyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
            etiquetaNombre.setText("Título");
            etiquetaDireccion.setText("Director");
            etiquetaNumero.setText("Clasificación");
            etiquetaTelefono.setText("Género");
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Cine");
        }
    }

    @FXML
    void insertar(ActionEvent event) {

    }

}
