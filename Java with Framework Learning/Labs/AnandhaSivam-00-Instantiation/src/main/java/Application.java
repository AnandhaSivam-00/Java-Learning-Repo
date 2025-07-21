public class Application {
    /**
     * This class contains a main method that allows you to manually test the Instantiation lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.instantiateANewObject method should return any newly-instantiated object.
     */
    public static void main(String[] args) {
        Lab inst = new Lab();
        System.out.println("An uninstantiated Object is a 'null' value in Java.");
        System.out.println("If we try to use a null Object like an instantiated Object,");
        System.out.println("We would probably get a NullPointerException, which would crash this program.");
        System.out.println("For instance, attempting to compare an Object to itself:");
        Object obj = inst.instantiateANewObject();
        System.out.println(obj.equals(obj));
    }
}
