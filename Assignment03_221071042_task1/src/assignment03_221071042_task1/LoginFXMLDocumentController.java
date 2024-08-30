/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package assignment03_221071042_task1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author CSE
 */
public class LoginFXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField userTF;
    @FXML
    private TextField passTF;
    @FXML
    private Button loginBTN;
    @FXML
    private Button exitBTN;
    //private Stage stage;
    @FXML
    private RadioButton maleRB;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private RadioButton otherRB;
    
    private ToggleGroup genderGroup;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // Initialize the ToggleGroup for the radio buttons
        genderGroup = new ToggleGroup();
        maleRB.setToggleGroup(genderGroup);
        femaleRB.setToggleGroup(genderGroup);
        otherRB.setToggleGroup(genderGroup);
    }
    
    @FXML
    private void login(ActionEvent event) throws IOException
    {
        if (event.getSource() == loginBTN) {
            String username = userTF.getText();
            String password = passTF.getText();

            RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
            String gender = selectedRadioButton != null ? selectedRadioButton.getText() : "Not selected";

            if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass")) {
                System.out.println(username);
                System.out.println(password);
                System.out.println("Gender: " + gender);
                System.out.println("Login Successfully");

                // For opening Profile Window
                Parent root = FXMLLoader.load(getClass().getResource("ProfileFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("INVALID!!");
            }
        }
        
    }
    @FXML
    private void handleExitButtonAction(ActionEvent event)
    {
        System.out.println("Exited");
        //label.setText("Exiting");
        Stage stage = (Stage) exitBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ToggleGroup(ActionEvent event) {
    }
}