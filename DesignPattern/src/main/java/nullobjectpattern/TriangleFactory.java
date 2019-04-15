package nullobjectpattern;

public class TriangleFactory{
    public static AbstractTriangle getTriangle(long a,long b,long c){
        if(a+b > c && a+c>b && b+c>a){
            return new RealTriangle(a, b, c);
        }
        else{
            return new NullTriangle();
        }
    }
}