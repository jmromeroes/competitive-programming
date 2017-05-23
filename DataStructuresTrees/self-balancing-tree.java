   /* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

static Node insert2(Node root, int val){
  if(root == null){
    root = new Node();
    root.right = null;
    root.left = null;
    root.ht = 0;
    root.val = val;
  } else {
    if(val > root.val){
      if(height(root.right) >= height(root.left)){
        root.ht += 1;
      }
      root.right = insert2(root.right, val);
    } else {
      if(height(root.right) <= height(root.left)){
        root.ht += 1;
      }
      root.left = insert2(root.left, val);
    }
  }
  
  return root;
}

static int height(Node root){
  if(root == null)
    return -1;
  else 
    return root.ht;
}

static int setHeight(Node root){
  if(root == null)
    return -1;
  
  if(root.left == null && root.right == null)
    root.ht = 0;
  else
    root.ht = Math.max(setHeight(root.left), setHeight(root.right)) + 1;
    
  return root.ht;
}

static Node balance(Node root){
  if(root != null){
    root.right = balance(root.right);
    root.left = balance(root.left);
    
    if(height(root.left) - height(root.right) > 1){
        Node aux = null;
        Node r = root.left;
        
        if(root.left.right != null)
            aux = root.left.right;
        root.left.right = root;
                  
        root.left = aux;

        return r;
    } else if(height(root.right) - height(root.left) > 1){
        Node aux = null;
        Node r = root.right;
        
        if(root.right.left != null)
            aux = root.right.left;          
        
        root.right.left = root;
        root.right = aux;
            
        return r;
    } else {        
        return root;
    }
  } 
  
  return null;
}

static String tree(Node root){
  if(root == null){
    return " null ";
  } else {
    return "Node " + root.val + " - " + root.ht + "(" + tree(root.left) + ", " + tree(root.right) + " )"; 
  } 
}

static Node insert(Node root,int val) {
    insert2(root, val);
    Node res = balance(root);
    
    setHeight(res);
    return res;
}
