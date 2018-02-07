package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanConverter {
    public static int Convert(String s) {
        Pattern pat = Pattern.compile("^[A-Z]{1}$", Pattern.CASE_INSENSITIVE);
        Map<Character, Integer> roman = new HashMap();

        s = s.toUpperCase();
        //if (pat.matcher(s).find()){
          //  throw new RuntimeException("Invalid input.");
        //}
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int sum = 0, count = 0;
        char cn = 'z';
        for (char c: s.toCharArray()){
            if (roman.containsKey(c) == false){
                throw new RuntimeException("Invalid figure found");
            }
            if (cn == c)
                count++;
            else//CMX CIX
                count = 0;
            if (count == 3)
                throw new RuntimeException("Invalid sequence");
            cn = c;
        }

        for (int i = 0; i < s.length(); i++) {
            //
            if (i < s.length() - 1) {
                if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1)))
                    sum -= roman.get(s.charAt(i));
                else
                    sum += roman.get(s.charAt(i));
            } else
                sum += roman.get(s.charAt(i));
        }
        return sum;
    }
}