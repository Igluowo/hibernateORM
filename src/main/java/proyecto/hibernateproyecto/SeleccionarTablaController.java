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

/**
 * FXML Controller class
 *
 * @author erick
 */
public class SeleccionarTablaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
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
    void cambiarVentana(ActionEvent event) {

    }
    
}
