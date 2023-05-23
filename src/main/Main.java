package main;
import  classes.BallGame.BallGame;
import classes.ChickenGame.ChickenGame;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;



public class Main extends Application{ 
    public static void main(String []args) {
        launch(args);
    }   
    @Override
    public void start(Stage primaryStage) throws Exception{ 
        startUP();
    }
    public void startUP(){
        Stage primaryStage = new Stage();
        Label l1 = new Label("GAME HUB");
        l1.setScaleX(10);
        l1.setScaleY(9);
        l1.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 17));
        l1.setTextFill(Color.rgb(255, 255, 255));


        Button b1 = new Button("Ball Game");
        Button b2= new Button("Chicken Game");
        Button b3 = new Button("Exit");


        b1.setPrefSize(505, 50);
        b2.setPrefSize(505, 50);
        b3.setPrefSize(505, 50);


        b1.setTextFill(Color.BLACK);
        b2.setTextFill(Color.BLACK);
        b3.setTextFill(Color.BLACK);
        
        b1.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 17));
        b2.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 17));
        b3.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 17));  
        
        
        b1.setBackground(Background.fill(Color.GOLD));
        b1.setShape(new Circle(20));
        b2.setBackground(Background.fill(Color.GOLD));
        b2.setShape(new Circle(20));
        b3.setBackground(Background.fill(Color.GOLD));
        b3.setShape(new Circle(20));

        b1.setOnAction(e->{    
            primaryStage.close();
            new BallGame();
        });
        b1.setOnMouseEntered(e ->{
            b1.setBackground(Background.fill(Color.GOLDENROD));
        });
        b1.setOnMouseExited(e->{
            b1.setBackground(Background.fill(Color.GOLD));
        });

        b2.setOnAction(e->{
            primaryStage.close();
            new ChickenGame();
        });
        b2.setOnMouseEntered(e ->{
            b2.setBackground(Background.fill(Color.GOLDENROD));
        });
        b2.setOnMouseExited(e->{
            b2.setBackground(Background.fill(Color.GOLD));
        });    

        b3.setOnAction(e->{
            primaryStage.close();
        });
        b3.setOnMouseEntered(e ->{
            b3.setBackground(Background.fill(Color.GOLDENROD));
        });
        b3.setOnMouseExited(e->{
            b3.setBackground(Background.fill(Color.GOLD));
        });


        Pane backGround = new Pane();
        ImageView backGroundImage = new ImageView(new Image("D:src/images/StartUpImages/startUpImage.jpg"));
        backGroundImage.fitWidthProperty().bind(backGround.widthProperty());
        backGroundImage.fitHeightProperty().bind(backGround.heightProperty());
        backGround.getChildren().add(backGroundImage);


        Scene s = new Scene(backGround, 1000, 700);
        VBox vBox = new VBox();
        VBox.setMargin(l1, new Insets(50, 50, 50, 50));
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(l1,b1,b2,b3);
        vBox.setPrefSize(backGround.getWidth(), backGround.getHeight());
        backGround.getChildren().add(vBox);
        


        primaryStage.setTitle("GAME HUB");
        primaryStage.setScene(s);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("D:src/images/StartUpImages/startUpImage.jpg"));        
        
        primaryStage.show();
    }
    
}