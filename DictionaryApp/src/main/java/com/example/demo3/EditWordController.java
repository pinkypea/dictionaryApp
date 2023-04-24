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

public class EditWordController {
    @FXML
    private TextField English;

    @FXML
    private TextField NewVietnamese;

    public void editWordFromDictionary(ActionEvent event) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dicManagement = new DictionaryManagement(dictionary);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        dicManagement.insertFromFile();
        String english = English.getText();
        String newVietnamese = NewVietnamese.getText();
        String vietnamese = dictionary.searchWord(english);
        if (vietnamese != null) {
            if (dictionary.editWord(english, vietnamese, english, newVietnamese) == true) {
                dicManagement.deleteInFile();
                dicManagement.dictionaryExportToFile();
                alert.setContentText("Successful word correction!");
                alert.show();
            } else {
                alert.setContentText("Word correction failed, please try again!");
                alert.show();
            }
        } else {
            alert.setContentText("Not in the dictionary, please re-enter!");
            alert.show();
        }
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
