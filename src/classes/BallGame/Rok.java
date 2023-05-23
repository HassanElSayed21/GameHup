package classes.BallGame;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rok extends Pane {
    Image player;
    ImageView player1;
    ImageView player2;
    ImageView player3;
    ImageView player4;
    ImageView player5;
    ImageView player6;    

    public Rok(String color){

    if(color.equals("donaroma"))
        {    
            player = new Image("D:src/images/BallGameImages/donnarumma.png");
            player1  = new ImageView(player);
            player1.setFitHeight(80);
            player1.setFitWidth(80);
            getChildren().add(player1);     
        }

    else if(color.equals("debrune"))
        {    
            player = new Image("D:src/images/BallGameImages/debrune.png");
            player2  = new ImageView(player);
            player2.setFitHeight(80);
            player2.setFitWidth(80);
            getChildren().add(player2);     
        }



    
    else if(color.equals("navas"))
        {    
            player = new Image("D:src/images/BallGameImages/navas.png");
            player3  = new ImageView(player);
            player3.setFitHeight(80);
            player3.setFitWidth(80);
            getChildren().add(player3);     
        } 
        
    else if(color.equals("messi"))
        {    
            player = new Image("D:src/images/BallGameImages/messi.png");
            player4  = new ImageView(player);
            player4.setFitHeight(80);
            player4.setFitWidth(80);
            getChildren().add(player4);     
        }

    else if(color.equals("xavi"))
        {    
            player = new Image("D:src/images/BallGameImages/xavi.png");
            player5  = new ImageView(player);
            player5.setFitHeight(80);
            player5.setFitWidth(80);
            getChildren().add(player5);     
        }
    else if(color.equals("otamendi"))
        {    
            player = new Image("D:src/images/BallGameImages/otamendi.png");
            player6  = new ImageView(player);
            player6.setFitHeight(110);
            player6.setFitWidth(110);
            getChildren().add(player6);     
        }            

    }
    
    
    public void setPlayer(Image player) {
        this.player = player;
    }

    public Image getPlayer() {
        return player;
    }

    
    
    
}
