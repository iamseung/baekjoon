import java.util.*;

class Solution {
    static boolean[][] visit;
    static int N, M;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dist;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;

        dist = new int[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }
    
        return BFS(maps);
    }
    
    static int BFS(int[][] maps) {
        Queue<Integer> que = new LinkedList<>();
        
        int ANS = -1;
        
        que.add(0);
        que.add(0);
        dist[0][0] = 1;
        
        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            
            if(x == M-1 &&  y == N-1) {
                ANS = dist[y][x];
                break;
            }
            
            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(dist[ny][nx] != -1) continue;
                if(maps[ny][nx] == 0) continue;
                
                que.add(nx);
                que.add(ny);
                
                dist[ny][nx] = dist[y][x] + 1;
            }
        }
        
        return ANS;
    }
}