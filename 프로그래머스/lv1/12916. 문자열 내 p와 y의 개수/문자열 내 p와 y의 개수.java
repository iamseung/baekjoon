class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int p = 0, y = 0;
        
        for(char c : s.toCharArray())
        {
            if(c == 'P') p++;
            
            if(c == 'Y') y++;
        }

        if(p == y) return true;
            
        return false;
    }
}