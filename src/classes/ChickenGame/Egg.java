package classes.ChickenGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Egg extends Item{
    private GamePane pane;
    private Plane plane;
    private Chicken chicken;
    private Timeline lifeTime;
    public Egg(GamePane pane, Plane plane,Chicken chicken){
        super("../../images/ChickenGameImages/egg.png");
        this.pane = pane;
        this.plane = plane;
        this.chicken = chicken;
        this.setPositionX(this.chicken.getPositionX()+50);
        this.setPositionY(this.chicken.getPositionY()+100);
        this.lifeTime = getlifeTime();
        this.pane.getChildren().add(this.getShape()); 
    }
    private Timeline getlifeTime(){
        Timeline lifeTime = new Timeline(new KeyFrame(Duration.millis(10),e ->{
            this.setPositionY(getPositionY()+1);
            if(this.getShape().getBoundsInParent().intersects(plane.getShape().getBoundsInParent()) && this.plane.getAlive()){
                this.lifeTime.stop();
                disappear();
                this.pane.getPlane().setAlive(false);
                // this.pane.getChildren().remove(this.plane.getShape());
                this.pane.setOnMouseClicked(null);
            }
            if(this.getPositionY()>pane.getHeight()){
                this.lifeTime.stop();
                disappear();
            }
        }));
        lifeTime.setCycleCount(Timeline.INDEFINITE);
        lifeTime.play();
        return lifeTime;
    }
    private void disappear(){
        pane.getChildren().remove(this.getShape());
    }
}
