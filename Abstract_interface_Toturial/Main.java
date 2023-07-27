public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog("Dog","lucky");
        dog.makeSound();
        dog.sleep();
        dog.getName();
        Animal chicken = new Chicken("Chicken","piko");
        chicken.getName();
        if(chicken instanceof  Chicken){
            ((Chicken) chicken).howToEat();
        }
    }
}