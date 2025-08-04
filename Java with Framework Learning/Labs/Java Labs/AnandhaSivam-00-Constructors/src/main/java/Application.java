public class Application {
    /**
     * This class contains a main method that allows you to manually test the Constructors lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Player class.
     *
     * The Player class should have constructors that allow other developers to instantiate the Objects in a certain
     * way.
     */
    public static void main(String[] args) {
        System.out.println("When a Player is created with a one-arg constructor,");
        System.out.println("it should have the provided name and a level of one.");
        System.out.println("Creating player 'Makro', should have the name 'Makro' and a level of 1: ");
        Player p1 = new Player("Makro");
        System.out.println("His name is: " + p1.playerName);
        System.out.println("His level is : " + p1.level);

        System.out.println("When a Player is created with a two-arg constructor,");
        System.out.println("it should have the provided name and level.");
        System.out.println("Creating player 'Vikas' with level 5, should have the name 'Vikas' and a level of 5: ");
        Player p2 = new Player("Vikas", 5);
        System.out.println("His name is: " + p2.playerName);
        System.out.println("His level is : " + p2.level);
    }
}
