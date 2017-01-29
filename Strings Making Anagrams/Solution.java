import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        int count = 0;
        HashMap<Character, Integer> str1Map = generateHashMap(first);
        HashMap<Character, Integer> str2Map = generateHashMap(second);

        for(int i=0; i<first.length(); i++){
            char ch = first.charAt(i);
            if(!second.contains(Character.toString(ch))){
                str1Map.remove(ch);
                count++;
            }
        }
        for(int i=0; i<second.length(); i++){
            char ch = second.charAt(i);
            if(!first.contains(Character.toString(ch))){
                str2Map.remove(ch);
                count++;
            }
        }

        if(str1Map.equals(str2Map)){
            return count;
        }
        for(Map.Entry<Character, Integer> m:str1Map.entrySet()){
            char ch = m.getKey();
            int value = m.getValue();
            if(value != str2Map.get(ch)){
                int diff = Math.abs(value - str2Map.get(ch));
                count = count + diff;
            }
        }
        return count;
    }
    
    private static HashMap<Character, Integer> generateHashMap(String uniqueStr1) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<uniqueStr1.length(); i++){
            char ch = uniqueStr1.charAt(i);
            if(map.containsKey(ch)){
                int value = map.get(ch);
                value++;
                map.put(ch, value);
            }else{
                map.put(ch, 1);
            }
        }
        return map;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
