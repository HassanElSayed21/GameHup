package classes.BallGame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Goal extends Pane {
    
    Image go;
    ImageView goalleft;
    ImageView goalright ;

    public Goal(String place){
        if(place.equals("right")){
            go = new Image("file:///C:/Users/User/Desktop/GameHub/src/images/BallGameImages/netRight.png");
            goalright = new ImageView(go);
            goalright.setFitHeight(250);
            goalright.setFitWidth(160);
            getChildren().add(goalright);     

        }
        else if(place.equals("left")){
            go = new Image("D:src/images/BallGameImages/netLeft.png");
            goalleft = new ImageView(go);
            goalleft.setFitHeight(250);
            goalleft.setFitWidth(160);
            getChildren().add(goalleft);    
        }

    }

}
