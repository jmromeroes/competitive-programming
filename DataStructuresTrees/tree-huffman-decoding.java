/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String s ,Node root){
    Node n = root;
  
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == '1'){
          n = n.right;
          if(n.data != '\0'){
              System.out.print(n.data);
              n = root;
          }
      } else {
          n = n.left;
          if(n.data != '\0'){
              System.out.print(n.data);
              n = root;
          }
      }
    }         
}
