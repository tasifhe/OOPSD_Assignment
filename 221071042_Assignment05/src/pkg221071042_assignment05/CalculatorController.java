/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pkg221071042_assignment05;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author tasif
 */
public class CalculatorController {

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleDigit(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (start) {
            display.setText(value);
            start = false;
        } else {
            display.setText(display.getText() + value);
        }
    }

    @FXML
    private void handleOperation(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        }
    }

    @FXML
    private void handleSquare() {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.pow(value, 2)));
    }

    @FXML
    private void handleCube() {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.pow(value, 3)));
    }

    @FXML
    private void handleEquals() {
        if (operator.isEmpty()) return;
        double num2 = Double.parseDouble(display.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        display.setText(String.valueOf(result));
        operator = "";
        start = true;
    }

    @FXML
    private void handleClear() {
        display.setText("");
        operator = "";
        num1 = 0;
        start = true;
    }
}