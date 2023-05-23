package classes.ChickenGame;
import classes.ChickenGame.Alert.AlertType;
import classes.ChickenGame.Stages.StagesStatus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;

public class ChickenGame extends Stage{
    private GamePane pane ;
    private Stages stages ;
    private Scene scene ;
    private Timeline endGame;
    public ChickenGame(){
        this.getIcons().add(new Image("D:src/images/ChickenGameImages/logo.jpg"));
        pane = new GamePane();
        stages = new Stages(pane);
        scene = new Scene(pane,1200,800);
        runChickenGame();
        endGame = getEndgame();
    }
    public GamePane getGamePane(){
        return this.pane;
    }
    private void runChickenGame(){
        setScene(scene);
        setTitle("ChickenInvaders");
        setResizable(false);
        pane.prepareSpace();
        pane.preparePlane();
        stages.getStage(StagesStatus.FIRSTSTAGE);
        show();
        setOnCloseRequest(e ->{
            close();
            new Main().startUP();
        });
        scene.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.ESCAPE){
                close();
                new Main().startUP();
            }
        });
    }
    private Timeline getEndgame(){
        Timeline endGame = new Timeline(new KeyFrame(Duration.millis(50),e ->{
            if(!pane.getPlane().getAlive()){
                this.endGame.stop();
                new Alert(this, AlertType.DeathAlert);
            }
            int size = this.getGamePane().getChickens().size();
            int numOfChickenDied=0;
            for(int i=0;i<size;i++){
                if(!this.getGamePane().getChickens().get(i).getAlive())
                    numOfChickenDied++;
            }
            if(size == numOfChickenDied){
                this.endGame.stop();
                this.pane.setOnMouseMoved(null);
                this.pane.setOnMouseClicked(null);
                this.pane.setOnMouseDragged(null);
                new Alert(this, AlertType.WINALERT);
            }   
        }));
        endGame.setCycleCount(Timeline.INDEFINITE);
        endGame.play();
        return endGame;
    }
    
}
