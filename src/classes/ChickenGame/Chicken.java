package classes.ChickenGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Chicken extends Item{
    private Plane plane;
    private GamePane pane;
    private Timeline touchPlane;
    private Timeline createEggs;
    private Timeline rotation;
    private Timeline motion;
    private int health;
    private boolean alive;
    private double angleOfRotation = 0;
    private Boolean cycleOfRotation = true;
    private double move = 0;
    private boolean cycleOfMotion = true;
    public Chicken(GamePane pane,Plane plane,double x, double y){
        super("../../images/ChickenGameImages/chicken.png"); //width 100 , Hight nearly 60
        this.pane = pane;
        this.plane = plane;
        this.touchPlane = setTouchPlane();
        touchPlane = setTouchPlane();
        this.health = 2;
        this.alive = true;
        setPositionX(x);
        setPositionY(y);
        move();
        this.createEggs = createEggs();
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public boolean getAlive(){
        return this.alive;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
    public void killChicken(){
        this.alive = false;
        this.getShape().setVisible(false);
        this.rotation.stop();
        this.motion.stop();
    }
    private Timeline setTouchPlane(){
        Timeline touchPlane = new Timeline(new KeyFrame(Duration.millis(20),e->{
            if(this.getShape().getBoundsInParent().intersects(this.plane.getShape().getBoundsInParent()) && this.getAlive()){
                this.pane.getPlane().setAlive(false);
                this.pane.setOnMouseClicked(null);
                this.touchPlane.stop();
            }
        }));
        touchPlane.setCycleCount(Timeline.INDEFINITE);
        touchPlane.play();
        return touchPlane;
    }
    private Timeline createEggs(){
        
        Timeline creatEggs = new Timeline(new KeyFrame(Duration.seconds(5+(Math.random()*30)),e ->{
            if(getAlive()){
                new Egg(pane, plane, this);
            }
            else{
                this.createEggs.stop();
            }
        }));
        creatEggs.setCycleCount(Timeline.INDEFINITE);
        creatEggs.play();
        return creatEggs;
    } 
    public void move(){
        getStartMove();
        getRotation();
        getShiftMove();
    }
    private void getStartMove(){
        Timeline motion = new Timeline(new KeyFrame(Duration.millis(10),e->{
            this.setPositionY(this.getPositionY()+1);
        }));
        motion.setCycleCount(315);
        motion.play();
    }
    private void getRotation(){
        rotation = new Timeline(new KeyFrame(Duration.millis(30),e->{
            if(cycleOfRotation){
                this.getShape().setRotate(++angleOfRotation);
                if(angleOfRotation==10){
                    cycleOfRotation = false;
                }
            }
            else{
                this.getShape().setRotate(--angleOfRotation);
                if(angleOfRotation == -10){
                    cycleOfRotation = true;
                }
            }
        })); 
        rotation.setCycleCount(Timeline.INDEFINITE);
        rotation.play();
    }
    private void getShiftMove(){
        motion = new Timeline(new KeyFrame(Duration.millis(50),e ->{
            if(cycleOfMotion){
                this.setPositionX(this.getPositionX()+(++move));
                if(move >= 10){
                    cycleOfMotion = false;
                    move=0;
                }
            }
            else{
                this.setPositionX(this.getPositionX()+(--move));
                if(move <= -10){
                    cycleOfMotion = true;
                    move =0;
                }
            }
        }));
        motion.setCycleCount(Timeline.INDEFINITE);
        motion.play();
    }
    
}
