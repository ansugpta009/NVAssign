

/**
 * Compare string with another string that contains same characters
 * 
 * @author Manish Singh
 * @created-time june 22,2021 9pm
 * @param input   String            
 * @return  remove leading and trailing 0 from num and return rest
 * @throws NullPointerException if happens
 */
import java.util.*;
public class removeZeros {
    public static void main(String[] args) throws NullPointerException {
        Scanner scn = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scn.nextLine());
        System.out.println(removeTrailingZeroes(removeLeadingZeroes(input))); ;
        scn.close();
    }
    public static StringBuilder removeLeadingZeroes(StringBuilder sb) {
       
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb;
    }
    
    public static StringBuilder removeTrailingZeroes(StringBuilder sb) {
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }
   
    

    
}