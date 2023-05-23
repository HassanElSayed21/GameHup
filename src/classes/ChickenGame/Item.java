package classes.ChickenGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
    private ImageView shape;
    private double positionX;
    private double positionY;

    public Item(String URL){
        this.shape = new ImageView(new Image(getClass().getResource(URL).toString()));
    }

    public ImageView getShape() {
        return this.shape;
    }

    public void setShape(ImageView shape) {
        this.shape = shape;
    }

    public double getPositionX() {
        return this.positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
        shape.setX(positionX);
    }

    public double getPositionY() {
        return this.positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY; 
        shape.setY(positionY);
    }
}
