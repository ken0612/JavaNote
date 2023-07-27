public class Dog extends Animal implements Edible{

    public Dog(String animalType,String animalName){
        super(animalType,animalName);
    }

    @Override
    public void makeSound(){
        System.out.println("bark!");
    }

    @Override
    public void howToEat() {
        System.out.println(this.animalType +" can't eat");
    }

    @Override
    public Boolean Edible() {
        return false;
    }
}
