/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment01_22304100_task2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tasif
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button exitbtn;

    @FXML
    private void handleButtonAction1(ActionEvent event)
    {
        System.out.println("You Clicked Button1");
        label.setText("Button 1");
    }
    @FXML
    private void handleButtonAction2(ActionEvent event)
    {
        System.out.println("You Clicked Button2");
        label.setText("Button 2");
    }
    @FXML
    private void handleButtonAction3(ActionEvent event)
    {
        System.out.println("You Clicked Button3");
        label.setText("Button 3");
    }
    @FXML
    private void handleButtonAction4(ActionEvent event)
    {
        System.out.println("You Clicked Button4");
        label.setText("Button 4");
    }
    @FXML
    private void handleExitButtonAction(ActionEvent event)
    {
        System.out.println("Exited");
        label.setText("Exiting");
        Stage stage = (Stage) exitbtn.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
