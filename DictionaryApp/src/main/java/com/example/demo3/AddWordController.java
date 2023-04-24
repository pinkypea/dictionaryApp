package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddWordController {
    @FXML
    private TextField English;
    @FXML
    private TextField Vietnamese;

    public void addWordToDictionary(ActionEvent event) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dicManagement = new DictionaryManagement(dictionary);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String english = English.getText();
        String vietnamese = Vietnamese.getText();
        dictionary.insertWord(english, vietnamese);
        dicManagement.dictionaryExportToFile();
        alert.setContentText("Add words of success!");
        alert.show();
    }
    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainScreen.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }
}
