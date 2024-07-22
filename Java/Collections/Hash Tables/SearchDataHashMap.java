import java.util.*;

public class HashTableExample {
    public static void main(String[] args) {
        HashMap<String, String> hashTable = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of data inputs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key for item " + (i + 1) + ": ");
            String key = scanner.nextLine();
            System.out.print("Enter value for item " + (i + 1) + ": ");
            String value = scanner.nextLine();
            hashTable.put(key, value);
        }

        while (true) {
            System.out.print("Enter a key to search (or 'exit' to quit): ");
            String searchKey = scanner.nextLine();

            if (searchKey.equalsIgnoreCase("exit")) {
                break;
            }

            if (hashTable.containsKey(searchKey)) {
                System.out.println("Value found: " + hashTable.get(searchKey));
            } else {
                System.out.println("Key not found in the hash table.");
            }
        }
    }
}