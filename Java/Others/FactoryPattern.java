interface Plane {
  public void fly();
}

class Airbus implements Plane {
  @Override
  public void fly() {
    System.out.println("Airbus is flying");
  }
}
class Boeing implements Plane {
  @Override
  public void fly() {
    System.out.println("Boeing is flying");
  }
}

class Factory {
  public static Plane getPlane(String type) {
    switch(type) {
        case "Airbus":
          return new Airbus();
        case "Boeing":
          return new Boeing();
        default:
        return null;
    }
  }
}

public class FactoryPattern {
  public static void main(String args[]) {
    Plane plane = Factory.getPlane("Airbus");
    plane.fly();
    plane = Factory.getPlane("Boeing");
    plane.fly();
  }
}