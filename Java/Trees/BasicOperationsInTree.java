import java.util.*;

class BinarySerachTree {
  class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  Node root = null;
  public void insertNode(int data) {
    root = insertRec(root, data);
    System.out.println("Inserted " + data + " successfully");
  }

  protected void displayOp(int op) {
    switch(op) {
      case 1:
        displayInorder(root);
        break;
      case 2:
        displayPreorder(root);
        break;
      case 3:
        displayPostorder(root);
        break;
    }
  }

  protected void displayInorder(Node root) {
    if(root != null) {
      displayInorder(root.left);
      System.out.print(root.data + " ");
      displayInorder(root.right);
    }
  }

  protected void displayPreorder(Node root) {
    if(root != null) {
      System.out.print(root.data + " ");
      displayPreorder(root.left);
      displayPreorder(root.right);
    }
  }

  protected void displayPostorder(Node root) {
    if(root != null) {
      displayPostorder(root.left);
      displayPostorder(root.right);
      System.out.print(root.data + " ");
    }
  }

  protected Node insertRec(Node root, int data) {
    if(root == null) {
      root = new Node(data);
      return root;
    }

    if(data < root.data) {
      root.left = insertRec(root.left, data);
    }
    else if(data > root.data) {
      root.right = insertRec(root.right, data);
    }

    return root;
  }
}

public class BasicOperationsInTree {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    BinarySerachTree bst = new BinarySerachTree();
    boolean flag = false;

    while(true) {
      switch(sc.nextInt()) {
        case 1:
          bst.displayOp(1);
          break;
        case 2:
          bst.displayOp(2);
          break;
        case 3:
          bst.displayOp(3);
          break;
        case 4:
          bst.insertNode(sc.nextInt());
          break;
        default:
          System.out.println("Invalid choice");
          flag = true;
          break;
      }

      if(flag) {
        break;
      }
    }
  }
}