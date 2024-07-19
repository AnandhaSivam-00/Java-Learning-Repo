abstract class Animal {

  public abstract void makeSound();

  public void move() {
    System.out.println(getClass().getSimpleName()+" is moving");
    //getClass().getSimpleName() is an inbuilt functionality of Java
    //to get the class name from which the method is being called
  }

}

class Dog extends Animal {

    @Override
    public void makeSound() {
    System.out.println("Woof Woof...");
  }

}

class Cat extends Animal {

    @Override
    public void makeSound() {
    System.out.println("Meow Meow...");
  }

}

class Sheep extends Animal {

    @Override
    public void makeSound() {
    System.out.println("Baa Baa..");
  }

}

class AbstractClassAndMethods {

  public static void main(String args[]) {
    // Creating the objects
    Animal dog = new Dog();  
    Animal cat = new Cat();
    Animal sheep = new Sheep();

    dog.makeSound();    // Calling methods from Dog
    dog.move();

    cat.makeSound();    // Calling methods from Cat
    cat.move();

    sheep.makeSound();  // Calling methods from Sheep
    sheep.move();
  }

}