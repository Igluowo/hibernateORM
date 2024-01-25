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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class PantallaPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Parent root;
    private Stage escena;
    private Scene scene;

    @FXML
    private Button actualizarDatos;

    @FXML
    private Button aniadirDatos;

    @FXML
    private Button eliminarDatos;

    @FXML
    private Button visualizarDatos;

    public PantallaPrincipalController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void cambiarVentana(ActionEvent event) throws IOException {
        String ventana = "";
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        if (event.getSource() == visualizarDatos) {
            ventana = "VisualizarDatos.fxml";
        } else if (event.getSource() == eliminarDatos) {
            ventana = "EliminarDatos.fxml";
        } else if (event.getSource() == aniadirDatos) {
            ventana = "SeleccionarInsertar.fxml";
            App.setAccion("añadir");
        } else {
            ventana = "SeleccionarInsertar.fxml";
            App.setAccion("actualizar");
        }
        FXMLLoader escenaFMXL = new FXMLLoader(App.class.getResource(ventana));
        root = escenaFMXL.load();
        scene = new Scene(root);
        escena = new Stage();
        escena.setScene(scene);
        escena.show();
    }

}
