   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   
   void LevelOrder(Node root) {
       ArrayList<Node> list     = new ArrayList<Node>();
       ArrayList<Node> toRemove = new ArrayList<Node>();
       ArrayList<Node> toAdd    = new ArrayList<Node>();
     
       list.add(root);
     
       while(!list.isEmpty()){
           for(Node n: list){
               toRemove.add(n);
               System.out.print(n.data + " ");             
            
               if(n.left != null){
                   toAdd.add(n.left);
               }
             
               if(n.right != null){
                   toAdd.add(n.right); 
               }
             
           } 
           list.removeAll(toRemove);
           list.addAll(toAdd);
           toAdd.clear();
           toRemove.clear();
       }
   }
