import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            a[c_i] = in.nextInt();
        }
        int count = 0;
        HashMap<Integer, Integer> mapArray = new HashMap<Integer, Integer>();
        for(int i=0; i < n; i++){
            if(mapArray.containsKey(a[i])){
                int value = mapArray.get(a[i]);
                value++;
                mapArray.put(a[i], value);
            }else{
                mapArray.put(a[i], 1);
            }
            
        }
        
        for(Map.Entry<Integer, Integer> m:mapArray.entrySet()){
            int v = m.getValue();
            count += (v/2);
        }
        System.out.println(count);
    }
}
