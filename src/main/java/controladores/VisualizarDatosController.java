/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import entidades.Cine;
import entidades.Funcion;
import entidades.Pelicula;
import entidades.Protagonista;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import proyecto.hibernateproyecto.App;
import repositorio.CineRepositorio;
import repositorio.FuncionRepositorio;
import repositorio.PeliculaRepositorio;
import repositorio.ProtagonistaRepositorio;
import repositorio.TarifaRepositorio;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class VisualizarDatosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> listaTablas = FXCollections.observableArrayList();
        listaTablas.add("Cine");
        listaTablas.add("Pelicula");
        listaTablas.add("Funcion");
        listaTablas.add("Tarifa");
        listaTablas.add("Protagonista");
        listaTablas.add("Peliculas por cine");
        listaTablas.add("Cines por protagonista en Peliculas");
        listaTablas.add("Películas asociadas al protagonista y sus cines");
        comboTabla.setItems(listaTablas);
    }

    private String resultado = "-----------------------";

    @FXML
    private TextArea areaResultado;

    @FXML
    private Button botonVisualizar;

    @FXML
    private Button botonVolver;

    @FXML
    private ComboBox<String> comboTabla;

    @FXML
    private Label etiquetaConsulta;

    @FXML
    private TextField fieldConsulta;
    
    CineRepositorio cine = new CineRepositorio();
    
    PeliculaRepositorio pelicula = new PeliculaRepositorio();
    
    FuncionRepositorio funcion = new FuncionRepositorio();
    
    ProtagonistaRepositorio protagonista = new ProtagonistaRepositorio();
    
    TarifaRepositorio tarifa = new TarifaRepositorio();

    @FXML
    void visualizar(ActionEvent event) {
        String tabla = comboTabla.getValue();
        String consulta = fieldConsulta.getText();
        switch (tabla) {
            case "Cine":
                Session sesionCine = cine.crearSesion();
                List<Cine> listaCine = cine.consultar(sesionCine);
                for (Cine cineElemento : listaCine) {
                    cineElemento.toString();
                    resultado += cineElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Pelicula":
                Session sesionPelicula = pelicula.crearSesion();
                List<Pelicula> listaPelicula = pelicula.consultar(sesionPelicula);
                for (Pelicula peliculaElemento : listaPelicula) {
                    peliculaElemento.toString();
                    resultado += peliculaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Protagonista":
                Session sesionProtagonista = protagonista.crearSesion();
                List<Protagonista> listaProtagonista = protagonista.consultar(sesionProtagonista);
                for (Protagonista protagonistaElemento : listaProtagonista) {
                    protagonistaElemento.toString();
                    resultado += protagonistaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Funcion":
                Session sesionFuncion = funcion.crearSesion();
                List<Funcion> listaFuncion = funcion.consultar(sesionFuncion);
                for (Funcion funcionElemento : listaFuncion) {
                    funcionElemento.toString();
                    resultado += funcionElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Tarifa":
                Session sesionTarifa = tarifa.crearSesion();
                List<Tarifa> listaTarifa = tarifa.consultar(sesionTarifa);
                for (Tarifa tarifaElemento : listaTarifa) {
                    resultado += tarifaElemento.toString();
                    resultado += "-----------------------";
                }
                break;
            case "Peliculas por cine":
                Session sesionCinePelicula = cine.crearSesion();
                Cine cineId = obtenerCine(consulta);
                List<Pelicula> listaCinePelicula = pelicula.consultarPeliculasCine(sesionCinePelicula, cineId);
                for (Pelicula cinesPeliculas : listaCinePelicula) {
                    resultado += "\n" + cinesPeliculas.toString() + "\n";
                    resultado += "-----------------------";
                }
            case "Cines por protagonista en Peliculas":
                Session sesionCineProtagonista = cine.crearSesion();
                List<Cine> listaCineProtagonista = cine.devolverCineProtas(sesionCineProtagonista, consulta);
                for (Cine cinesProtagonista : listaCineProtagonista) {
                    resultado += "\n" + cinesProtagonista.toString() + "\n";
                    resultado += "-----------------------";
                }
            case "Películas asociadas al protagonista y sus cines":
                Session sesionProtagonistaCine = protagonista.crearSesion();
                List<Object[]> listaProtagonistaPeliculaCine = protagonista.
                        devolverPeliculaCineProta(sesionProtagonistaCine, consulta);
                for (Object[] resultados : listaProtagonistaPeliculaCine) {
                    Pelicula peliculaDatos = (Pelicula) resultados[0];
                    Cine cineDatos = (Cine) resultados[1];
                    resultado += "\nPelicula: " + peliculaDatos.getTitulo() + "\nCine: " + cineDatos.getNombre();
                    resultado += "\n-----------------------";
                }

        }

        areaResultado.setText(resultado);
        resultado = "-----------------------";
    }

    private Cine obtenerCine(String consulta) {
        Session session = cine.crearSesion();
        return cine.consultarId(session, consulta);
    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader escena = new FXMLLoader(App.class
                .getResource("PantallaPrincipal.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
