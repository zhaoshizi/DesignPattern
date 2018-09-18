package builderpattern;

public class MealBuilder{
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurge());
        meal.addItem(new Tea());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurge());
        meal.addItem(new Coke());
        return meal;
    }
}