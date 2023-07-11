import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String X, String Y) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] numbers = new int[10];
        boolean notZero = false;
        
        for(int i=0; i<Y.length(); i++) numbers[Y.charAt(i)-'0']++;
        
        for(char c : X.toCharArray()) {
            if(numbers[c-'0'] > 0) {
                arr.add(c-'0');
                numbers[c-'0']--;
                
                if(c-'0' != 0) notZero = true;
            }    
        }
        
        if(arr.size() == 0) return "-1";
        if(!notZero) return "0";
        Collections.sort(arr);
        
        for(int n : arr) sb.append(String.valueOf(n));
        return sb.reverse().toString();
    }
}