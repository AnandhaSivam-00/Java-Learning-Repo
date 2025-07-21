public class Application {
    /**
     * This class contains a main method that allows you to manually test the FizzBuzz challenge functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.FizzBuzzGen method should return Fizz, Buzz, FizzBuzz, or a blank space depending on the divisibility
     * of the number provided.
     */
    public static void main(String[] args) {
        Lab fizzBuzzLab = new Lab();
        System.out.println("Given the number 3, the lab should return Fizz:");
        System.out.println(fizzBuzzLab.FizzBuzzGen(3));
        System.out.println("Given the number 5, the lab should return Buzz:");
        System.out.println(fizzBuzzLab.FizzBuzzGen(5));
        System.out.println("Given the number 7, the lab should return a blank space:");
        System.out.println(fizzBuzzLab.FizzBuzzGen(7));
        System.out.println("Given the number 15, the lab should return FizzBuzz:");
        System.out.println(fizzBuzzLab.FizzBuzzGen(15));
    }
}
