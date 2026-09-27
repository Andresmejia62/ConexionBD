package com.appregistros.conexionbd.controller;

import com.appregistros.conexionbd.connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.sql.Connection;

public class PrincipalController {

    @FXML
    private Label lblestado;

    @FXML
    private void initialize(){
        System.out.println("PrincipalController initialized, lblestado=" + lblestado);
    }

    @FXML
    private void probarconexion(){
        System.out.println("probarconexion invoked");
        try(Connection connection = DatabaseConnection.getConnection()){
            lblestado.setText("Conexion exitosa");
            System.out.println("Conexion exitosa");
        }
        catch(Exception e){
            lblestado.setText("ERROR al conectar");
            System.out.println("Conexion failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}