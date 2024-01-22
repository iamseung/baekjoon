import java.util.*;

class Solution {
    static int answer = 0;
    static int depth = 0;
    static String[] alpha = {"A","E","I","O","U"};
    
    public int solution(String word) {
        answer = 0;
        dfs("", word);
        return answer;
    }

    private void dfs(String st, String word) {
        if (st.length() > 5) return;
        if (st.equals(word)) {
            answer = depth;
            return;
        }
        
        depth++;
        
        for(int i=0; i<5; i++) 
            dfs(st + alpha[i], word);
        
    }
}