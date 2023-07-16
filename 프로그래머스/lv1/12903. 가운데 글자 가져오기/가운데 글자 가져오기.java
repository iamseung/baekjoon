class Solution {
    public String solution(String s) {
        int L = s.length();
        
        if(L%2 == 0)
            return String.valueOf(s.charAt(L/2-1)) + String.valueOf(s.charAt(L/2));
        else
            return String.valueOf(s.charAt(L/2));
    }
}