// Base class Bird
class Bird {   

  // Common trait of all birds so implemented in the base class
  public void eat() { 
    System.out.println(getClass().getSimpleName() + " is eating!");
  }

}// End of Bird class

interface CanFly {

  // The method is by default abstract and public
  void flying();   

}// End of CanFly interface

class Parrot extends Bird implements CanFly { // Parrot is extending from Bird and implementing CanFly

  @Override               // If you don't implement the flying() you will get an error!
  public void flying() { // Overriding the method of CanFly interface
    System.out.println("Parrot is Flying!");
  }
} // End of Parrot class

class Penguin extends Bird { // Penguin is a bird so extending from Bird

  // Penguin cannot fly so not implementing CanFly
  public void walk() {
    System.out.println("Penguin is Walking!");
  }

} // End of Penguin class

class InterfaceExample {

  public static void main(String[] args) {

    Parrot parrot = new Parrot();   // Creating the Parrot object
    Penguin penguin = new Penguin(); // Creating the Penguin object

    parrot.eat();
    parrot.flying();

    System.out.println();    // Just creating a newline on console

    penguin.eat();
    penguin.walk();

  } // End of main()

} // End of Main class