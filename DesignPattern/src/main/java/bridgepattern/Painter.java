package bridgepattern;

public class Painter extends Peaple{
    public Painter(DrawAPI drawAPI){
        super(drawAPI);
    }
    @Override
    public void draw(){
        System.out.print("Draw well and ");
        drawAPI.drawWithPen();
    }
}