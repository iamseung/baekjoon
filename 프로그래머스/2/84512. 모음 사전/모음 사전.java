class Solution {
    static int answer = 0;
    static int depth = 0;
    static final int len = 5;
    static String[] alpha = {"A","E","I","O","U"};
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    static void dfs(String st, String word) {
        if(st.length() > len)
            return;

        if(st.equals(word)) {
            answer = depth;
            return;
        }

        depth++;

        for(int i=0; i<len; i++)
            dfs(st + alpha[i], word);
    }
}