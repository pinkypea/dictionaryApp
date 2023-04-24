package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.KeyException;
import java.util.ArrayList;

public class DictionaryController {
    @FXML
    private TextArea English;

    @FXML
    private TextArea Vietnamese;

    @FXML
    private ListView<String> Word;

    @FXML
    public void translate(ActionEvent event) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dicManagement = new DictionaryManagement(dictionary);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        dicManagement.insertFromFile();
        String english = English.getText();
        String vietnamese = dictionary.searchWord(english);
        if (vietnamese != null) {
            Vietnamese.setText(vietnamese);
        } else {
            alert.setContentText("Not in the dictionary, please re-enter!");
            alert.show();
        }
    }

    @FXML
    public void suggestedWord(KeyEvent event) throws IOException{
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dicManagement = new DictionaryManagement(dictionary);
        dicManagement.insertFromFile();
        Word.getItems().clear();
        String english = English.getText().trim();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Word> listWord = new ArrayList<>(dictionary.getDictionaryList());
        for (int i = 0; i < listWord.size(); i++) {
            String s = listWord.get(i).getWord_target();
            if (s.startsWith(english) == true) {
                arrayList.add(s);
            }
        }
        Word.getItems().addAll(arrayList);
    }

    @FXML
    public void speak(ActionEvent event) {
        String english = English.getText();
        TextToSpeech speech = new TextToSpeech(english);
    }
    @FXML
    public void addWord(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addWord.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }

    @FXML
    public void deleteWord(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("deleteWord.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }

    @FXML
    public void editWord(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editWord.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }
}
