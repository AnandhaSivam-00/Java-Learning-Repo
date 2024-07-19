class Vehicle {              //base class of vehicle

    private String make;    //
    private String color;   // Vehicle Fields
    private int year;       //
    private String model;   //


    public Vehicle(String make, String color, int year, String model) {
        this.make = make;    //
        this.color = color;  // Constructor of Vehicle
        this.year = year;    //
        this.model = model;  //
    }

    public void printDetails() {  //public method to print details
        System.out.println("Manufacturer: " + make);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
    }

}

class Car extends Vehicle {    //derived class of Car

    private String bodyStyle;  //Car field

    public Car(String make, String color, int year, String model, String bodyStyle) {
        super(make, color, year, model);  //parent class constructor
        this.bodyStyle = bodyStyle;       
    }

    public void carDetails() {  //details of car
        printDetails();         //calling method from parent class
        System.out.println("Body Style: " + bodyStyle);
    }

}

public class Super_This_Keywords {

    public static void main(String[] args) {
        Car elantraSedan = new Car("Hyundai", "Red", 2019, "Elantra", "Sedan"); //creation of car Object
        elantraSedan.carDetails(); //calling method to print details
    }

}