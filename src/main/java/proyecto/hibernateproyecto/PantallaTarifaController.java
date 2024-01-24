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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

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
        if (App.getAccion() == "actualizar") {
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Tarifa");
        }
    }    
    
    @FXML
    private Button botonInsertar;

    @FXML
    private ComboBox<?> comboCine;

    @FXML
    private TextField fieldDia;

    @FXML
    private Spinner<?> fieldPrecio;

    @FXML
    private Label tituloVentana;

    @FXML
    void insertar(ActionEvent event) {
        
    }    
}
