class Solution {
    static boolean[] visited;
    static int dicLength, cnt = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        dicLength = begin.length();
        visited = new boolean[words.length];
        
        dfs(0, begin, target, words);

        return cnt == Integer.MAX_VALUE ? 0 : cnt;
    }
    
    static void dfs(int k, String cur, String target, String[] words) {
        if(cur.equals(target)) {
            cnt = Math.min(cnt, k);
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(cur.equals(words[i])) continue;
            if(visited[i]) continue;
            if(!isAvailble(cur, words[i])) continue;

            visited[i] = true;
            dfs(k+1, words[i], target, words);
            visited[i] = false;
        }
    }

    static boolean isAvailble(String A, String B) {
        int gap = 0;

        for(int i=0; i<dicLength; i++) {
            if(A.charAt(i) != B.charAt(i)) gap++;
        }

        return gap == 1;
    }
}