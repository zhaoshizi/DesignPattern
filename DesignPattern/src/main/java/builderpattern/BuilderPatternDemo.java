package builderpattern;

public class BuilderPatternDemo{
    public static void main(String args[]){
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("VegMeal:");
        vegMeal.showItems();
        System.out.println("Cost: "+ vegMeal.getCost());
        System.out.println("NonVegMwal:");
        nonVegMeal.showItems();
        System.out.println("Cost: " + nonVegMeal.getCost());
    }
}