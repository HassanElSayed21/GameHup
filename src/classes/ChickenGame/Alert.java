package classes.ChickenGame;

import main.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Alert {
    public static enum AlertType{
        DeathAlert,WINALERT;
    }
    private ChickenGame chickenGame;
    public Alert(ChickenGame chickenGame ,AlertType alertType){
        this.chickenGame = chickenGame;
        getAlert(alertType);
    }
    private void getAlert(AlertType alertType){
        switch(alertType){
            case DeathAlert :{createAlert("GAMEOVER");
            break;    
            }
            case WINALERT:{createAlert("WINNER WINNER");
            break;
            }
        }
    }
    private void createAlert(String title){
        VBox pane = new VBox();
        pane.setLayoutX(400);
        pane.setLayoutY(300);
        pane.setPrefSize(400,300);
        ImageView imageView = new ImageView(new Image("D:src/images/ChickenGameImages/logo.jpg"));
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        pane.getChildren().add(imageView);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        Label body = new Label(title);
        body.setFont(Font.font(Font.getFamilies().get(1),50));
        body.setTextFill(Color.RED);
        Button again = new Button("AGAIN");
        again.setPrefWidth(200);
        again.setOnAction(e ->{
            this.chickenGame.close();
            new ChickenGame();
        });
        Button exit = new Button("EXIT");
        exit.setPrefWidth(200);
        exit.setOnAction(e ->{
            this.chickenGame.close();
            new Main().startUP();
        });
        pane.getChildren().addAll(body,again,exit);
        this.chickenGame.getGamePane().getChildren().add(pane);

    }
}
