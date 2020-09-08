/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	if(root == null) return null;
        if(root.data == v1 || root.data == v2){
            return root;
        }

        Node leftTry = lca(root.left, v1, v2);
        Node rightTry = lca(root.right, v1, v2);

        if(leftTry != null && rightTry != null){
            return root;
        } else if(leftTry != null){
            return leftTry;
        } else {
            return rightTry;
        }
    }
