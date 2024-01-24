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
public class InsertarFuncionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    void insertar(ActionEvent event) {

    }

    
}
