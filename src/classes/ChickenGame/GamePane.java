package classes.ChickenGame;
import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class GamePane extends Pane{

    private Space space ;
    private Plane plane;
    private ArrayList<Chicken> chickens ;
    public GamePane(){
        space = new Space();
        plane = new Plane(this);
        chickens = new ArrayList<>();
        this.getChildren().addAll(space.getShape(),plane.getShape());
    }
    public Plane getPlane(){
        return this.plane;
    }

    public void prepareSpace(){
        this.space.getShape().fitWidthProperty().bind(this.widthProperty());
        this.space.getShape().fitHeightProperty().bind(this.heightProperty());
    }

    public void preparePlane(){
        plane.setPositionX((this.getWidth()/2)-38);
        plane.setPositionY((this.getHeight()-50)-40);
        plane.motion();
        plane.trowShot();
    }

    public ArrayList<Chicken> getChickens(){
        return this.chickens;
    }
}   
