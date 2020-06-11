import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, ArrayList<Integer>> reference = new HashMap();
        int triplets = 0;
        for(int i = 0; i < arr.size(); i++){
            if(reference.containsKey(arr.get(i)/r) && reference.containsKey(arr.get(i)/r/r)){               
                ArrayList<Integer> l1 = reference.get(arr.get(i)/r);
                ArrayList<Integer> l2 = reference.get(arr.get(i)/r/r);

                for(int y = 0; y < l2.size(); y++){
                    int v2 = l2.get(y);

                    for(int x= l1.size() - 1; x >= 0; x--){
                        int v3 = l1.get(x);

                        if(v2 < v3){
                            triplets += 1;
                        } else {
                            break;
                        }   
                    }
                }
            }
            if(reference.containsKey(arr.get(i))){
                reference.get(arr.get(i)).add(i);
            } else {
                ArrayList<Integer> a = new ArrayList();
                a.add(i);
                reference.put(arr.get(i), a);
            }
        }

        return triplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
