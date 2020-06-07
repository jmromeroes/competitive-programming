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



class Result {
    /*
     * Complete the 'minimumSwaps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING status as parameter.
     */
    
    public static int minimumSwaps(String status) {
        int res = 0;
        int res2 = 0;

        for(int i = 0; i < status.length(); i++){
            if(i % 2 == 0){
                if(status.charAt(i) == 'R'){
                    res++;
                }
            } else{
                if(status.charAt(i) == 'S'){
                    res++;
                }
            }
        }

        for(int i = 0; i < status.length(); i++){
            if(i % 2 == 0){
                if(status.charAt(i) == 'S'){
                    res2++;
                }
            } else{
                if(status.charAt(i) == 'R'){
                    res2++;
                }
            }
        }

        return Math.min(res, res2);
    }

}

public class Solution {
