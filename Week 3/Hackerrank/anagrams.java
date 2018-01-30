import java.io.*;
import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);
        int iterations = input.nextInt();
        input.nextLine();
        for (int i = 0; i < iterations; i++) {
                System.out.println(anagram(input.nextLine()));
        }
}

public static int anagram (String str) {
        if (str.length() % 2 != 0) return -1;

        int length = str.length()/2;
        String a = str.substring(0, length);
        String b = str.substring(length, str.length());

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (map.containsKey(c))
                        map.put(c, map.get(c) + 1);
                else
                        map.put(c, 1);
        }

        int diff = 0;
        for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (map.containsKey(c) && map.get(c) > 0)
                        map.put(c, map.get(c) - 1);
                else
                        diff++;
        }
        return diff;
}
}
