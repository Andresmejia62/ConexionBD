package com.appregistros.conexionbd.model;

import com.appregistros.conexionbd.controller.EstudianteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class EstudianteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EstudianteApplication.class.getResource("/com/appregistros/conexionbd/lista-estudiantes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Lista Estudiantes");
        stage.setScene(scene);
        stage.show();
    }

}
