public abstract class Animal {
    private String animalType;

    public void Animal(){

    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public String getAnimalType(){
        return this.animalType;
    }

    public void makeSound(){}
    public void sleep(){
        System.out.println(this.animalType + " is sleeping");
    }
}
