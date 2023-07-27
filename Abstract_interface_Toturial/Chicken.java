public class Chicken extends Animal implements Edible{

    public Chicken(String animalType,String animalName){
        super(animalType,animalName);
    }

    @Override
    public void makeSound(){
        System.out.println("cluck");
    }

    @Override
    public void howToEat() {
        System.out.println("i love fried chicken");
    }

    @Override
    public Boolean Edible() {
        return true;
    }
}
