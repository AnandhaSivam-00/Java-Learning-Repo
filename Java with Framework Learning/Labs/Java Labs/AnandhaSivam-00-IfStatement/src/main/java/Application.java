public class Application {
    /**
     * This class contains a main method that allows you to manually test the IfStatement lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     */
    public static void main(String[] args) {
        System.out.println("The Lab.ifExample method should return value a if bool is true, and value b if bool is false.");
        Lab ifLab = new Lab();

        System.out.println("Given the values true, a=2, b=4, the lab should return 2 and it returns the following: ");
        boolean bool1 = true;
        int a1 = 2;
        int b1 = 4;
        int output1 = ifLab.ifExample(bool1, a1, b1);
        System.out.println(output1);

        System.out.println("Given the values false, a=1, b=5, the lab should return 5 and it returns the following: ");
        boolean bool2 = false;
        int a2 = 1;
        int b2 = 5;
        int output2 = ifLab.ifExample(bool2, a2, b2);
        System.out.println(output2);
    }
}
