import java.util.List;

public class Application {
    /**
     * This class contains a main method that allows you to manually test the Lists lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods should perform List operations.
     */
    public static void main(String[] args) {

        Lab listLab = new Lab();
        System.out.println("Was the list properly instantiated? this will print '[]' if yes, null if no");
        List<Integer> myList = listLab.createList();
        System.out.println(myList);

        System.out.println("If we're able to add to a list, we should be able to add an item and then get it.");
        listLab.addToList(myList, 5);
        int item1 = listLab.get(myList, 0);
        System.out.println("after 5 is added, the item at index 0 should be 5. Currently it is: ");
        System.out.println(item1);

        listLab.addToList(myList, 7);
        int item2 = listLab.get(myList, 1);
        System.out.println("after 7 is added, the item at index 1 should be 7. Currently it is: ");
        System.out.println(item2);

        System.out.println("after those two numbers are added, the size should be 2. Currently it is: ");
        int size1 = listLab.getSize(myList);
        System.out.println(size1);

        listLab.removeFromList(myList, 1);
        System.out.println("after the item at index 1 is removed the size should be 1. Currently is is: ");
        int size2 = listLab.getSize(myList);
        System.out.println(size2);

    }
}
