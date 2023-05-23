package classes.ChickenGame;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Shot extends Item{
    private GamePane pane;
    private Plane plane;
    private Timeline lifeTime;
    private Timeline kill;

    public Shot(GamePane pane , Plane plane){
        super("../../images/ChickenGameImages/shot.png"); // width 20 , Height 40
        this.pane = pane;
        this.plane = plane; 
        this.lifeTime =createLifeTime();
        this.kill = checkKill();
    }
    private Timeline createLifeTime(){
        setMotion(this.plane.getPositionX()+38, this.plane.getPositionY());
        Timeline life = new Timeline(new KeyFrame(Duration.millis(1000),e ->{
            killShot();
        })); 
        life.setCycleCount(1);
        life.play();
        return life;
    }
    private Timeline checkKill(){
        Timeline killedOrNot = new Timeline(new KeyFrame(Duration.millis(20), e ->{
            if(pane.getChickens().size()!=0){
                int size = pane.getChickens().size();
                for(int i=0 ;i<size;i++){
                    if(pane.getChickens().get(i).getShape().getBoundsInParent().intersects(this.getShape().getBoundsInParent()) && pane.getChickens().get(i).getAlive()){
                        killShot();
                        if(pane.getChickens().get(i).getHealth()==0)
                            pane.getChickens().get(i).killChicken();  
                        else
                            pane.getChickens().get(i).setHealth(pane.getChickens().get(i).getHealth()-1);
                    }
                }
            }
        }));
        killedOrNot.setCycleCount(Timeline.INDEFINITE);
        killedOrNot.play();
        return killedOrNot;
    }

    private void killShot(){
        this.lifeTime.stop();
        this.kill.stop();
        this.Disappeared();
    }

    private void Disappeared(){
        pane.getChildren().remove(this.getShape());
    }
    private void setMotion(double startX,double startY){
        PathTransition shotPath = new PathTransition(Duration.millis(1000),new Line(startX,startY,startX,-100),this.getShape());
        shotPath.setCycleCount(1);
        shotPath.play();
    }
}
