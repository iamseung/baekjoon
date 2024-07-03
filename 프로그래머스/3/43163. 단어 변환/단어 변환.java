import java.util.*;

class Solution {
    static int count = Integer.MAX_VALUE;
    static boolean[] visited;
    static int len;
    
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        visited = new boolean[len];

        dfs(begin, target, words, 0);

        return (count == Integer.MAX_VALUE) ? 0 : count;
    }
    
    static void dfs(String cur, String target, String[] words, int depth) {
        if(cur.equals(target)) {
            count = Math.min(count, depth);
            return;
        }

        for(int i=0; i<len; i++) {
            if(cur.equals(words[i])) continue;
            if(visited[i]) continue;
            if(!isCorret(cur, words[i])) continue;

            visited[i] = true;
            dfs(words[i], target, words, depth+1);
            visited[i] = false;
        }
    }

    static boolean isCorret(String cur, String next) {
        int gap = 0;

        for(int i=0; i<cur.length(); i++) {
            if(next.charAt(i) != cur.charAt(i))
                gap++;
        }

        return gap == 1;
    }
}