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

static Node rightRotate(Node root){
    Node aux = null;
    Node r = root.left;
        
    if(root.left.right != null)
        aux = root.left.right;
    root.left.right = root;
                  
    root.left = aux;

    return r;
}

static Node leftRotate(Node root){
    Node aux = null;
    Node r = root.right;
        
    if(root.right.left != null)
        aux = root.right.left;          
        
    root.right.left = root;
    root.right = aux;
            
    return r;
}

static Node leftRightRotate(Node root){
    root.right = rightRotate(root.right);
    return leftRotate(root);  
}

static Node rightLeftRotate(Node root){
    root.left = leftRotate(root.left);
    return rightRotate(root);  
}

static int getBalance(Node root){
    return height(root.right) - height(root.left);  
}

static Node balance(Node root){
  if(root != null){
    root.right = balance(root.right);
    root.left = balance(root.left);
    
    if(height(root.left) - height(root.right) > 1){
        if(getBalance(root.left) >= 0){
          return rightLeftRotate(root);
        }
      
        return rightRotate(root);
    } else if(height(root.right) - height(root.left) > 1){
        if(getBalance(root.right) <= 0){
          return leftRightRotate(root);        
        }
      
        return leftRotate(root);
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
    return "Node " + root.val + " - " + getBalance(root) + "(" + tree(root.left) + ", " + tree(root.right) + " )"; 
  } 
}

static Node insert(Node root,int val) {
    insert2(root, val);
    Node res = balance(root);    
    setHeight(res);
  
    return res;
}
