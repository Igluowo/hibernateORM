/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import proyecto.hibernateproyecto.App;
import repositorio.CineRepositorio;
import repositorio.TarifaRepositorio;

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
        Session sesion = cineRepo.crearSesion();
        List<Cine> listaCine = cineRepo.consultar(sesion);
        ObservableList<String> listaString = FXCollections.observableArrayList();
        for (Cine cine : listaCine) {
            listaString.add(cine.getNombre());
        }
        comboCine.setItems(listaString);
        if (App.getAccion() == "actualizar") {
            labelId.setVisible(true);
            fieldId.setVisible(true);
            botonInsertar.setText("Actualizar");
            tituloVentana.setText("Actualizar la tabla Tarifa");
        }
    }

    @FXML
    private TextField fieldId;

    @FXML
    private Label labelId;

    @FXML
    private Button botonInsertar;

    @FXML
    private ComboBox<String> comboCine;

    @FXML
    private TextField fieldDia;

    @FXML
    private TextField fieldPrecio;

    @FXML
    private Label tituloVentana;

    TarifaRepositorio tarifa = new TarifaRepositorio();

    CineRepositorio cineRepo = new CineRepositorio();

    @FXML
    void insertar(ActionEvent event) {
        String cineString = comboCine.getValue();
        String dia = fieldDia.getText();
        String precio = fieldPrecio.getText();
        String id = fieldId.getText();
        Session sesion = tarifa.crearSesion();
        Cine cine = cineRepo.consultarId(sesion, cineString);
        sesion.close();
        sesion = tarifa.crearSesion();
        fieldDia.clear();
        comboCine.setValue("");
        fieldPrecio.clear();
        fieldId.clear();
        if (App.getAccion() == "añadir") {
            Tarifa tarifaObj = new Tarifa(dia, precio, cine);
            tarifa.insertar(sesion, tarifaObj);
        } else {
            Tarifa tarifaObj = new Tarifa(Integer.parseInt(id), dia, precio, cine);
            tarifa.actualizar(sesion, tarifaObj);
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
