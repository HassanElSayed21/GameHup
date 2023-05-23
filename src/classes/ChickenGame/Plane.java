package classes.ChickenGame;
public class Plane extends Item{
    private GamePane pane;
    private int score; 
    private boolean alive;
    public Plane(GamePane pane){
        super("../../images/ChickenGameImages/plane.png");// width 76 height 80
        this.pane = pane;
        this.alive = true;
        this.score =0;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
        this.getShape().setVisible(alive);
    }
    public boolean getAlive(){
        return this.alive;
    }
    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private Shot createShot(){
        Shot shot = new Shot(pane,this);
        return shot;
    }
    
    public void motion(){
        pane.setOnMouseMoved(e -> {
            this.setPositionX(e.getX()-38);
            this.setPositionY(e.getY()-40);
        });
        pane.setOnMouseDragged(e ->{
            this.setPositionX(e.getX()-38);
            this.setPositionY(e.getY()-40);
        });
    }
    public void trowShot(){ 
        pane.setOnMouseClicked(e ->{
            pane.getChildren().add(createShot().getShape());
        });
    }
    
    
}
