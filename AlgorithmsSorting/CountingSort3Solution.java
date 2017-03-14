import java.util.StringTokenizer;
import java.io.*;

public class CountingSort3Solution {

    public static void main(String[] args) {
	long ms = System.currentTimeMillis();
	MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
	int[] l = new int[100];
	StringBuilder[] ls = new StringBuilder[100];
        
	for(int x = 0; x < n; x++){
            int i = sc.nextInt();
            String s = sc.next();
              
	    if(x < n/2) {
                if(ls[i] == null)
                    ls[i] = new StringBuilder().append("- ");
                else
                    ls[i] = ls[i].append("- ");
	    }else{
                if(ls[i] == null)
                    ls[i] = new StringBuilder().append(s + " ");
                else
                    ls[i] = ls[i].append(s + " ");
            }
        }
      
        for(int y = 0; y < 100; y++){
            if(ls[y] != null)
                pw.print(ls[y].toString());
        }
        
        pw.flush()
    }

}

class MyScanner{

    BufferedReader br;
    StringTokenizer st;
      
    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    } 
      
    public String next(){
    
	while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    
	return st.nextToken();
    
    }
    
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public float nextFloat(){ 
        return Float.parseFloat(next());
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }
    
    public String nextLine(){
    
	String str = "";
    
        try {
            str = br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
      
        return str;
    }

}

