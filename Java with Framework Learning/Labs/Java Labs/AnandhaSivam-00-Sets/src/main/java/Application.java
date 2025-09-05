import java.util.Set;

public class Application {
    /**
     * This class contains a main method that allows you to manually test the Sets lab.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods should perform Set operations.
     */
    public static void main(String[] args) {
        Lab setLab = new Lab();
        System.out.println("Was the set properly instantiated? this will print '[]' if yes, null if no");
        Set<Integer> mySet = setLab.createSet();
        System.out.println(mySet);

        System.out.println("If we're able to add an item to the set, it should be present in the set (return true)");
        setLab.addUniqueItem(mySet, 5);
        System.out.println(mySet.contains(5));

        System.out.println("The set should not contain items not in the set (return false)");
        System.out.println(mySet.contains(7));

        System.out.println("After adding the item of the set, it should have a size of 1. Current size:");
        int size1 = setLab.getSize(mySet);
        System.out.println(size1);

        System.out.println("After removing the item of the set, it should have a size of 0. Current size:");
        setLab.removeItem(mySet, 5);
        int size2 = setLab.getSize(mySet);
        System.out.println(size2);
    }
}
