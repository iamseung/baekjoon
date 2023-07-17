import java.util.*;

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            try {
                int N = Integer.parseInt(s);
                return true;
            } 
            catch(Exception e) {
                return false;
            }    
        }
        
        return false;
    }
}