package singletonpattern;

public class SingletonPatternDemo{
    public static void main(String args[]){
        SingletonObject1 singletonObject1 = SingletonObject1.getInstance();
        SingletonObject2 singletonObject2 = SingletonObject2.getInstance();
        SingletonObject3 singletonObject3 = SingletonObject3.getInstance();
        singletonObject1.show();
        singletonObject2.show();
        singletonObject3.show();
    }
}