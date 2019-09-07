package module1.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

/**
 * @author Kelvin Susanto (1772039)
 */

public class duelAction {
    public Button buttonPaper;
    public Button buttonRock;
    public Button buttonScissors;

    public ImageView imgUser;
    public ImageView imgCom;
    Image rock = new Image(getClass().getResourceAsStream("../Image/Rock.png"));
    Image paper = new Image(getClass().getResourceAsStream("../Image/Paper.png"));
    Image scissors = new Image(getClass().getResourceAsStream("../Image/Scissors.png"));

    public TextField txtWin;
    public TextField txtDraw;
    public TextField txtLose;

    private int win = 0;
    private int draw = 0;
    private int lose = 0;
    String Pilcom;
    String Piluser;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void duelAction(ActionEvent actionEvent) {
        Random rnd = new Random();
        int com = rnd.nextInt(3);
        if (com == 0) {
            imgCom.setImage(rock);
            Pilcom = "rock";
        } else if (com == 1) {
            imgCom.setImage(paper);
            Pilcom = "paper";
        } else if (com == 2) {
            imgCom.setImage(scissors);
            Pilcom = "scissors";
        }

        if (actionEvent.getSource() == buttonRock) {
            imgUser.setImage(rock);
            Piluser = "rock";
        } else if (actionEvent.getSource() == buttonPaper) {
            imgUser.setImage(paper);
            Piluser = "paper";
        } else if (actionEvent.getSource() == buttonScissors) {
            imgUser.setImage(scissors);
            Piluser = "scissors";
        }

        if (Piluser.equals("rock") && Pilcom.equals("scissors") || Piluser.equals("paper") && Pilcom.equals("rock") || Piluser.equals("scissors") && Pilcom.equals("paper")){
            setWin(getWin()+1);
            txtWin.setText(Integer.toString(getWin()));
        } else if (Piluser.equals("rock") && Pilcom.equals("paper") || Piluser.equals("paper") && Pilcom.equals("scissors") || Piluser.equals("scissors") && Pilcom.equals("rock")){
            setLose(getLose()+1);
            txtLose.setText(Integer.toString(getLose()));
        } else {
            setDraw(getDraw()+1);
            txtDraw.setText(Integer.toString(getDraw()));
        }

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
