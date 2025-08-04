class FastCars {
    public void soundLevel() {
        System.out.println("High in Speed");
    }

    // public void frequencyLevel() {
    //     System.out.println("High in freq");
    // }
}

class Ferrari extends FastCars {
    @Override
    public void soundLevel() {
        System.out.println("Much sound as more");
    }
    
    // @Override
    public void frequencyLevel() {
        System.out.println("Mild freq");
    }
}

public class DownCasting {
    public static void main(String args[]) {
        FastCars obj = new Ferrari();
        // Ferrari obj = new FastCars();
        obj.soundLevel();
        // obj.frequencyLevel();
    }
}
