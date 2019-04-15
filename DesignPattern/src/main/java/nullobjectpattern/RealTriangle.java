package nullobjectpattern;

public class RealTriangle extends AbstractTriangle{
    public RealTriangle(long a,long b,long c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean isNull(){
        return false;
    }
    public String discribeTriangle(){
        return "Triangle: " + a +", " + b +", "+c;
    }
}