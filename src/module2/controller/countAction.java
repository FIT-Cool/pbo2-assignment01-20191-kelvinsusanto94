package module2.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class countAction extends Application {

    public TextField txtLength;
    public TextField txtWidth;
    public TextField txtRadius;
    public TextField txtHeight;

    private String submitID = "none";
    private double surfacearea = 0;
    private double volume = 0;
    DecimalFormat df = new DecimalFormat("#.00");

    Alert a = new Alert(Alert.AlertType.INFORMATION);

    public void setTxtLength(TextField txtLength) {
        this.txtLength = txtLength;
    }

    public void setTxtWidth(TextField txtWidth) {
        this.txtWidth = txtWidth;
    }

    public void setTxtRadius(TextField txtRadius) {
        this.txtRadius = txtRadius;
    }

    public void setTxtHeight(TextField txtHeight) {
        this.txtHeight = txtHeight;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    public void btnSubmit(ActionEvent actionEvent) {
        if (submitID.equals("Square")){
            int area = Integer.parseInt(txtHeight.getText()) * Integer.parseInt(txtWidth.getText());
            int perimeter = 2 * (Integer.parseInt(txtHeight.getText()) + Integer.parseInt(txtWidth.getText()));
            a.setContentText("Area: " + area + ", Perimeter: " + perimeter);
            a.show();
        } else if (submitID.equals("Ball")){
            surfacearea = 4 * ((Math.PI * (Math.pow(Double.parseDouble(txtRadius.getText()), 2.0))));
            volume = (4 * ((Math.PI * (Math.pow(Double.parseDouble(txtRadius.getText()), 3.0))))/3);
            a.setContentText("Surface Area: " + df.format(surfacearea) + ", Volume: " + df.format(volume));
            a.show();
        } else if (submitID.equals("Tube")){
            surfacearea = (2 * Math.PI * Integer.parseInt(txtRadius.getText()) * (Integer.parseInt(txtRadius.getText() + Integer.parseInt(txtHeight.getText()))));
            volume = (Math.PI * (Math.pow(Double.parseDouble(txtRadius.getText()), 2.0) * Integer.parseInt(txtHeight.getText())));
            a.setContentText("Surface Area: " + df.format(surfacearea) + ", Volume: " + df.format(volume));
            a.show();
        }
    }

    public void btnSquare(ActionEvent actionEvent) {
        txtLength.setText("");
        txtRadius.setText("");
        txtWidth.setText("");
        txtHeight.setText("");

        txtLength.setDisable(true);
        txtRadius.setDisable(true);
        txtWidth.setDisable(false);
        txtHeight.setDisable(false);

        submitID = "Square";
    }

    public void btnBall(ActionEvent actionEvent) {
        txtLength.setText("");
        txtRadius.setText("");
        txtWidth.setText("");
        txtHeight.setText("");

        txtLength.setDisable(true);
        txtRadius.setDisable(false);
        txtWidth.setDisable(true);
        txtHeight.setDisable(true);

        submitID = "Ball";
    }

    public void btnTube(ActionEvent actionEvent) {
        txtLength.setText("");
        txtRadius.setText("");
        txtWidth.setText("");
        txtHeight.setText("");

        txtLength.setDisable(true);
        txtRadius.setDisable(false);
        txtWidth.setDisable(true);
        txtHeight.setDisable(false);

        submitID = "Tube";
    }
}
