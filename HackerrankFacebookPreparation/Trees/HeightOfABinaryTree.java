/*
    class Node 
      int data;
      Node left;
      Node right;
*/
public static int getHeight(Node root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }

	public static int height(Node root) {
      	// Write your code here.
        return Math.max(getHeight(root.right), getHeight(root.left));
    }
