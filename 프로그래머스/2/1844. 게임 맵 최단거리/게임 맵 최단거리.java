import java.util.*;

class Solution {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int dirLen = 4;
    
    public int solution(int[][] maps) {
        int Y = maps.length;
        int X = maps[0].length;
        int[][] dist = new int[Y][X];

        for(int y=0; y<Y; y++)
            Arrays.fill(dist[y], -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[0];

            for(int k=0; k<dirLen; k++) {
                int nx = x + dir[k][1];
                int ny = y + dir[k][0];

                if(nx < 0 || ny < 0 || nx >= X || ny >= Y) continue;
                if(dist[ny][nx] != -1) continue;
                if(maps[ny][nx] == 0) continue;

                dist[ny][nx] = dist[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }

        return dist[Y-1][X-1];
    }
}