/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package assignment04_221071042_task1;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author tasif
 */
public class SignupFXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField fullnameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private DatePicker bdate;
    @FXML
    private RadioButton maleRB;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private RadioButton otherRB;
    @FXML
    private TextField cityTF;
    @FXML
    private Button signupBTN;
    
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
    private void handleSignup(ActionEvent event) throws IOException 
    {
        if (event.getSource() == signupBTN)
        {
            String fullname = fullnameTF.getText();
            String email = emailTF.getText();
            String city = cityTF.getText();
            String birthDate = bdate.getValue() != null ? bdate.getValue().toString() : "Not selected";

            RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
            String gender = selectedRadioButton != null ? selectedRadioButton.getText() : "Not selected";

            // Load ProfileFXML.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileFXML.fxml"));
            Parent root = loader.load();

            // Get the ProfileController and pass the data
            ProfileFXMLController profileController = loader.getController();
            profileController.setProfileData(fullname, email, city, birthDate,gender);


            // Show the Profile window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        else
        {
            System.err.println("Signup failed. Please check your inputs.");
        }
    }

}
