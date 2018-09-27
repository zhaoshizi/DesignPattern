package facadepattern;

public class FacadePatternDemo{
    public static void main(String argv[]){

        Helper helper = new Helper("123456","ABC","CS","CS");

        System.out.println(helper.getAsset());


    }
}