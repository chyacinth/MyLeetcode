import java.util.regex.*;
class Solution {
    public boolean isNumber(String s) {         
        String pattern = "(\\s*(\\+|\\-)?\\d+(\\.)?\\d*(e(\\+|\\-)?\\d+)?\\s*)" + "|" +
                                "(\\s*(\\+|\\-)?\\d*(\\.)?\\d+(e(\\+|\\-)?\\d+)?\\s*)";
 
        return Pattern.matches(pattern, s);        
    }
}