public class Application {
    /**
     * This class contains a main method that allows you to manually test creation of Bird objects modelled after
     * the Bird class.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Bird class.
     *
     * Bird objects should follow the behavior outlines in the documentation of the Bird class.
     */
    public static void main(String[] args) {

        System.out.println("This bird is 2 months old, and should Tweet. Here's the current sound: ");
        Bird b1 = new Bird();
        b1.ageMonths = 2;
        System.out.println(b1.sound());

        System.out.println("This bird is 6 months old, and should Chirp. Here's the current sound: ");
        Bird b2 = new Bird();
        b2.ageMonths = 6;
        System.out.println(b2.sound());

        System.out.println("This bird is 3 months old, and should Chirp. Here's the current sound: ");
        Bird b3 = new Bird();
        b3.ageMonths = 3;
        System.out.println(b3.sound());
    }
}
