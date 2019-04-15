package nullobjectpattern;

public class NullTriangle extends AbstractTriangle{
    public boolean isNull(){
        return true;
    }
    public String discribeTriangle(){
        return "not a Triangle.";
    }
}