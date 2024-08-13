//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    Node sortDLL(Node root) {
        if(root == null || root.bottom == null) {
            return root;
        }

        Node mid = findMiddle(root);
        Node left = root;
        Node right = mid.bottom;
        mid.bottom = null;

        left = sortDLL(left);
        right = sortDLL(right);

        return mergeSortedDLL(left, right);
    }

    Node mergeSortedDLL(Node left, Node right) {
        Node result = new Node(-1);
        Node temp = result;

        while(left != null && right != null) {
            if(left.data <= right.data) {
                temp.bottom = left;
                left = left.bottom;
            }
            else {
                temp.bottom = right;
                right = right.bottom;
            }
            temp = temp.bottom;
        }

        while(left != null) {
            temp.bottom = left;
            left = left.bottom;
            temp = temp.bottom;
        }

        while(right != null) {
            temp.bottom = right;
            right = right.bottom;
            temp = temp.bottom;
        }

        return result.bottom;
    }

    Node findMiddle(Node root) {
        Node slow = root;
        Node fast = root.bottom;

        while(fast != null && fast.bottom != null) {
            slow = slow.bottom;
            fast = fast.bottom.bottom;
        }
        return slow;
    }

    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root == null || (root.bottom == null && root.next == null)) {
            return root;
        }

        Node current = root;

        while(current != null) {
            Node subCurrent = current;

            while(subCurrent.bottom != null) {
                subCurrent = subCurrent.bottom;
            }
            subCurrent.bottom = current.next;

            current = current.next;
        }

        return sortDLL(root);
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        }
        sc.close();
    }
}

// } Driver Code Ends