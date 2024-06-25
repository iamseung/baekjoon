class Solution {
    static int answer = 0;
    static boolean[] visited;
    static int len;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        dfs(0,k,dungeons);

        return answer;
    }
    
    static void dfs(int depth, int fatigue, int[][] dungeons) {
        for(int i=0; i<len; i++) {
            // 이미 방문한 곳 OR 피로도가 더 높으면 Pass
            if(visited[i] || fatigue < dungeons[i][0])
                continue;

            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
    }
}