package com.appregistros.conexionbd.controller;

import com.appregistros.conexionbd.connection.DatabaseConnection;
import com.appregistros.conexionbd.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class EstudianteController {
    @FXML
    private TableView<Estudiante> tblEstudiante;

    @FXML
    private TableColumn<Estudiante, Integer> colId;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colCorreo;

    @FXML
    private TableColumn<Estudiante, String> colCarrera;

    @FXML
    private TableColumn<Estudiante, String> colTelefono;

    @FXML
    private TableColumn<Estudiante, Integer> colEdad;

    @FXML
    private TableColumn<Estudiante, LocalDate> colFechaIngreso;

    @FXML
    private TableColumn<Estudiante, BigDecimal> colPromedio;

    private final ObservableList<Estudiante> listaEstudiante = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        System.out.println("EstudianteController inicializado. tblEstudiante=" + tblEstudiante + ", colId=" + colId + ", colNombre=" + colNombre + ", colCorreo=" + colCorreo);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colPromedio.setCellValueFactory(new PropertyValueFactory<>("promedio"));
    }

    @FXML
    private void CargarEstudiantes(){
        System.out.println("CargarEstudiantes invoked");
        listaEstudiante.clear();

        String sql = "SELECT * FROM estudiante";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String carrera = resultSet.getString("carrera");
                String telefono = resultSet.getString("telefono");
                int edad = resultSet.getInt("edad");
                Date fechaIngresoSql = resultSet.getDate("fecha_ingreso");
                LocalDate fechaIngreso = (fechaIngresoSql != null) ? fechaIngresoSql.toLocalDate() : null;
                BigDecimal promedio = resultSet.getBigDecimal("promedio");

                Estudiante estudiante = new Estudiante(id, nombre, correo, carrera, telefono, edad, fechaIngreso, promedio);
                listaEstudiante.add(estudiante);

            }
            tblEstudiante.setItems(listaEstudiante);

        } catch (SQLException ex) {
            System.out.println("error al cargar estudiante: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}