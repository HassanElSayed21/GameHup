package classes.BallGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
// import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class BallGame {
    private Stage stage;
    private Label scoreLabel ;
    private Label winner ;
    
    private int x = 370 ;
    private int y = 110 ;

    private Rok r1 ;
    private Rok r2 ;
    private Rok r3 ;
    private Rok r4 ;
    private Rok r5 ;
    private Rok r6 ;
    
    private int score1 = 0;
    private int score2 = 0;
    private ball b1 ;
    private double ballDX = 2;
    private double ballDY = 2;

    private Image bg ;
    private ImageView background ;

    private ImageView fcb ; 
    private ImageView fcb1 ;

    private Goal rightGoal ;
    private Goal leftGoal ;


    // private Rectangle frame ;



    private Pane root ;




    private Timeline animation ;

    public BallGame(){
        this.stage = new Stage();
        BGame(stage);
    }
    private void BGame(Stage primaryStage){
               
       root = new Pane();
       root.setBackground(Background.fill(Color.BLACK));
       Scene scene = new Scene(root, 1000+x, 600+y);
       primaryStage.setTitle("Amazing BingBong");
       primaryStage.setScene(scene);
       primaryStage.initStyle(StageStyle.UTILITY);



        bg = new Image("D:src/images/BallGameImages/playGround.jpg");
        background = new ImageView(bg);
        background.setFitHeight(root.getHeight());
        background.setFitWidth(root.getWidth());
        root.getChildren().add(background);

        fcb1 = new ImageView(new Image("D:src/images/BallGameImages/logo.png"));
        fcb1.setFitHeight(root.getHeight()/6);
        fcb1.setFitWidth(root.getWidth()/6);
        fcb1.setLayoutX(830);
        fcb1.setLayoutY(310);
        root.getChildren().add(fcb1);

         
        fcb = new ImageView(new Image("D:src/images/BallGameImages/logo.png"));
        fcb.setFitHeight(root.getHeight()/6);
        fcb.setFitWidth(root.getWidth()/6);
        fcb.setLayoutX(310);
        fcb.setLayoutY(310);
        root.getChildren().add(fcb);

        winner = new Label("");
        //winner.setTextFill(Color.rgb(255, 200, 120));
        winner.setTextFill(Color.CRIMSON);
        winner.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 40));
        winner.setTranslateX((400));
        winner.setTranslateY(340);
        root.getChildren().add(winner);


        rightGoal = new Goal("right");
        rightGoal.setTranslateX(665+195+x);
        rightGoal.setTranslateY(120+y);
        root.getChildren().add(rightGoal);


        leftGoal = new Goal("left");
        leftGoal.setTranslateX(-25);
        leftGoal.setTranslateY(120+y);
        root.getChildren().add(leftGoal);



        r1 = new Rok("navas");
        r1.setTranslateX(80);
        r1.setTranslateY(170+y);
        root.getChildren().add(r1);

        

        r3 = new Rok("messi");
        r3.setTranslateX(110+200);
        r3.setTranslateY(240-150);
        root.getChildren().add(r3);

        r5 = new Rok("xavi");
        r5.setTranslateX(110+200);
        r5.setTranslateY(240+150+y);
        root.getChildren().add(r5);


        r2 = new Rok("donaroma");
        r2.setTranslateX(615+200+x);
        r2.setTranslateY(170+y);
        root.getChildren().add(r2);

        r4 = new Rok("debrune");
        r4.setTranslateX(585+200-200+x);
        r4.setTranslateY(240-150);
        root.getChildren().add(r4);

        r6 = new Rok("otamendi");
        r6.setTranslateX(585+200-200+x);
        r6.setTranslateY(240+150+y);
        root.getChildren().add(r6);




        b1 = new ball();
        b1.setTranslateX(390+200);
        b1.setTranslateY(260);
        root.getChildren().add(b1);


        scoreLabel = new Label("Player (1) : 0  |  Player (2) : 0");
        scoreLabel.setTextFill(Color.YELLOW);
        scoreLabel.setWrapText(true);
        scoreLabel.setFont(Font.font("OCR A Extended", /*خط مائل*/FontPosture.ITALIC, 35));
        scoreLabel.setTranslateX(x-37);
        scoreLabel.setTranslateY(8);
        root.getChildren().add(scoreLabel);

        // frame = new Rectangle(x-50, 5, 720, 50);
        // frame.setFill(null);
        // frame.setStroke(Color.BLACK);
        // frame.setStrokeWidth(8);
        // root.getChildren().add(frame);

        




        scene.setOnKeyPressed(e-> {
            if (e.getCode() == KeyCode.W && r1.getTranslateY() > 0) {
                r1.setTranslateY(r1.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.S && r1.getTranslateY() < 470) {
                r1.setTranslateY(r1.getTranslateY() + 10);
            }
            if (e.getCode() == KeyCode.UP && r2.getTranslateY() > 0) {
                r2.setTranslateY(r2.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.DOWN && r2.getTranslateY() < 470) {
                r2.setTranslateY(r2.getTranslateY() + 10);
            }
             if (e.getCode() == KeyCode.T && r3.getTranslateY() > 0) {
                r3.setTranslateY(r3.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.G && r3.getTranslateY() < 470) {
                r3.setTranslateY(r3.getTranslateY() + 10);
                
            }
            if (e.getCode() == KeyCode.O && r4.getTranslateY() > 0) {
                r4.setTranslateY(r4.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.L && r4.getTranslateY() < 470) {
                r4.setTranslateY(r4.getTranslateY() + 10);
            }
            if (e.getCode() == KeyCode.Y && r5.getTranslateY() > 0) {
                r5.setTranslateY(r5.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.H && r5.getTranslateY() < 470) {
                r5.setTranslateY(r5.getTranslateY() + 10);
                
            }
            if (e.getCode() == KeyCode.I && r6.getTranslateY() > 0) {
                r6.setTranslateY(r6.getTranslateY() - 10);
            } else if (e.getCode() == KeyCode.K && r6.getTranslateY() < 470) {
                r6.setTranslateY(r6.getTranslateY() + 10);
                
            }
        });


        
         animation = new Timeline(new KeyFrame(Duration.millis(6),e->{
                moveball();
                checkCollisions();
                checkScore();
                checkWinner();
         }));
         animation.setCycleCount(Timeline.INDEFINITE);
         animation.play();



        
        
        

        primaryStage.show();
    }


    public void moveball(){

        b1.setTranslateX(b1.getTranslateX()+ballDX);
        b1.setTranslateY(b1.getTranslateY()-ballDY);

    }


private void checkCollisions(){
            if(b1.getBoundsInParent().intersects(r1.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getBoundsInParent().intersects(r2.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getBoundsInParent().intersects(r3.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getBoundsInParent().intersects(r4.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getBoundsInParent().intersects(r5.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getBoundsInParent().intersects(r6.getBoundsInParent())){
                ballDX = -ballDX;
                ballDY = -ballDY;

            }

            if(b1.getTranslateY()<=0 || b1.getTranslateY()>=600){
                ballDY = - ballDY;
            }

            if(b1.getTranslateX()<=0 || b1.getTranslateX()>=800+200+x){
                ballDX = - ballDX;
            }

}


private void checkScore() {
            if (b1.getBoundsInParent().intersects(leftGoal.getBoundsInParent())) {
                score2++;
                updateScoreLabel();
                resetBall();
            } else if (b1.getBoundsInParent().intersects(rightGoal.getBoundsInParent())) {
                score1++;
                updateScoreLabel();
                resetBall();
            }
}

private void resetBall() {
            b1.setTranslateX(400+200);
            b1.setTranslateY(300);
            ballDX = Math.random() > 0.5 ? 2 : -2;
            ballDY = Math.random() > 0.5 ? 2 : -2;
}








private void updateScoreLabel() {
            scoreLabel.setText("Player (1) :  " + score1 + " |  Player (2) : " + score2);
}






private void checkWinner() {
    if(score1==4){
       
                winner.setText("Messi , Xavi And Navas Win ");
                resetScore();
                animation.stop();
                Timeline pauseTimeline = new Timeline( new KeyFrame(Duration.seconds(5), event ->{
                    } ));
                pauseTimeline.setCycleCount(0);
                pauseTimeline.setOnFinished(event ->{
                    winner.setText("");
                    animation.play();
                    });
                pauseTimeline.play();
    }

    else if(score2==4){
       
       
                    winner.setText("De Bryune , Otamendi And Donaroma Win ");
                    
                
                    resetScore();
                    animation.stop();
                    Timeline pauseTimeline = new Timeline( new KeyFrame(Duration.seconds(5), event ->{
                        } ));
                    pauseTimeline.setCycleCount(0);
                    pauseTimeline.setOnFinished(event ->{
                        winner.setText("");
                        animation.play();
                        });
                    pauseTimeline.play();

        
        }

}


private void resetScore() {                  
                    score1 =0;
                    score2 =0;
                    updateScoreLabel();

}


}
