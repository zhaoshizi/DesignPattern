package interceptingfilterpattern;

public class PreprocessFilter implements Filter{
    @Override
    public void excute(String request){
        System.out.println("Preprocess: " + request);
    }
}