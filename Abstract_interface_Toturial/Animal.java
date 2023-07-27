public abstract class Animal {
    protected String animalType;
    protected String animalName;

    public Animal(String animalType,String animalName){
        this.animalType = animalType;
        this.animalName = animalName;
    }

    public void getName(){
        System.out.println(this.animalName);
    }

    public void makeSound(){}
    public void sleep(){
        System.out.println(this.animalType + " is sleeping");
    }
}
