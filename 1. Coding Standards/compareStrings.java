/**
 * Compare string with another string that contains same characters
 * 
 * @author Manish Singh
 * @created-time june 22,2021 8:40pm
 * @param input  two String            
 * @return   boolean true if they are anagram, false if not 
 * @throws NullPointerException if happens
 */
import java.util.*;
public class compareStrings {
    public static void main(String[] args) throws NullPointerException {
        Scanner scn = new Scanner(System.in);
        StringBuilder stringOne = new StringBuilder(scn.next());
        StringBuilder stringTwo = new StringBuilder(scn.next());
        System.out.println(compare(stringOne, stringTwo)); ;
        scn.close();
    }

    public static boolean compare(StringBuilder stringOne, StringBuilder stringTwo) {
        if(stringOne.length()!=stringTwo.length()){
            return false;
        }
        int[] countCharMap = new int[26];
        for(int i=0;i<stringOne.length();i++){
            countCharMap[stringOne.charAt(i)-'a']++;
            countCharMap[stringTwo.charAt(i)-'a']--;
        }
        for(int i:countCharMap){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}