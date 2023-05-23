package classes.BallGame;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ball extends Pane {
    
    
    
    Image b ;
    ImageView ball ;
    
    
    
    public ball(){
    b = new Image("D:src/images/BallGameImages/Ball.png"); 
    ball = new ImageView(b);  
    ball.setFitHeight(30);
    ball.setFitWidth(30);
    getChildren().add(ball);   
    }
    
    
    public void setB(Image b) {
        this.b = b;
    }
    
    
    public Image getB() {
        return b;
    
    }
    
    public void setBall(ImageView ball) {
        this.ball = ball;
    }
    
    public ImageView getBall() {
        return ball;
    }    
}
