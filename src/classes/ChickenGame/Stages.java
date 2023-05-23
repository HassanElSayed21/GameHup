package classes.ChickenGame;
public class Stages {
    public static enum StagesStatus{
        FIRSTSTAGE;
    }

    private GamePane pane = new GamePane();


    public Stages(GamePane pane){
        this.pane = pane;
    }
    public void getStage(StagesStatus stagesStatus){
        switch(stagesStatus){
            case FIRSTSTAGE: getFirstStage();
        }
    }
    private void getFirstStage(){
        double startX=0 , startY=-300;
        int counter = 1;
        for(int i=0;i<48;i++){
            Chicken chicken = new Chicken(this.pane,this.pane.getPlane(), startX, startY);
            this.pane.getChickens().add(chicken);
            this.pane.getChildren().add(this.pane.getChickens().get(i).getShape());
            startX+=100;
            if(counter%12 == 0){
                startY+=60;
                startX =0;
            }
            counter++;
        }
    }
}
