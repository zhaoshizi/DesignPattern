package bridgepattern;

public abstract class Peaple{
    protected DrawAPI drawAPI;
    protected Peaple(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}