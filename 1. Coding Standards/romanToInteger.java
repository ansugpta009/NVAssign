/**
 * Convirt Roman Number String to Integer format
 * 
 * @author Manish Singh
 * @created-time june 22,2019 8:15pm
 * @param input  Roman Number as String            
 * @return   Integer value for given Roman Number 
 * @throws NullPointerException if happens
 */

import java.util.*;
public class romanToInteger {

    public static void main(String[] args) throws NullPointerException  {

        Scanner scn = new Scanner(System.in);
        StringBuilder romanNum = new StringBuilder(scn.nextLine());
        System.out.println(romanToInt(romanNum)); ;
        scn.close();
    }
        public static int romanToInt(StringBuilder romanNum) {
            HashMap<Character, Integer> romanNumMap = new HashMap<Character, Integer>();
            romanNumMap.put('I', 1);
            romanNumMap.put('V', 5);
            romanNumMap.put('X', 10);
            romanNumMap.put('L', 50);
            romanNumMap.put('C', 100);
            romanNumMap.put('D', 500);
            romanNumMap.put('M', 1000);
    
            int toInt = 0;
            for (int i = 0; i < romanNum.length(); i++) {
                if (i > 0 && romanNumMap.get(romanNum.charAt(i)) > romanNumMap.get(romanNum.charAt(i - 1))) {
                    toInt += romanNumMap.get(romanNum.charAt(i)) - 2 * romanNumMap.get(romanNum.charAt(i - 1));
                } else {
                     toInt += romanNumMap.get(romanNum.charAt(i));
                }
            }
            return toInt;
    }
}
  