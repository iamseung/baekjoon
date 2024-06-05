import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : my_string.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);  // Append non-alphabetic characters unchanged
            }
        }
        
        return result.toString();
    }
}