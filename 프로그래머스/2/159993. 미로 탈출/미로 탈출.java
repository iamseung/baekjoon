import java.util.*;
import java.io.*;

class Solution {
    static char[][] arr;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int X, Y;
    static int count = Integer.MAX_VALUE;
    static boolean[][] visit;
    static private final int DIR_NUM = 4;
    
    public int solution(String[] maps) {
        Y = maps.length;
        X = maps[0].length();

        int[] start = new int[2];
        int[] lv = new int[2];
        int[] end = new int[2];
        arr = new char[Y][X];
        visit = new boolean[Y][X];

        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++) {
                arr[i][j] = maps[i].charAt(j);

                // 출발지점
                if(arr[i][j] == 'S') {
                    start = new int[]{j,i};
                }

                // 레버 위치
                if(arr[i][j] == 'L') {
                    lv = new int[]{j,i};
                }

                // 도착지 위치
                if(arr[i][j] == 'E') {
                    end = new int[]{j,i};
                }
            }
        }

        int StartToLever = bfs(start, lv);
        int LeverToEnd = bfs(lv, end);
        
        if(StartToLever == -1 || LeverToEnd == -1) {
            return -1;
        }

        return StartToLever + LeverToEnd;
    }
    
    static int bfs(int[] start, int[] dest) {
        Queue<Integer> que = new LinkedList<>();

        int[][] dist = new int[Y][X];
        for(int i=0; i<Y; i++)
            Arrays.fill(dist[i], -1);

        que.add(start[0]);
        que.add(start[1]);

        dist[start[1]][start[0]] = 0;

        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for(int k=0; k<DIR_NUM; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx == dest[0] && ny == dest[1]) {
                    return dist[y][x] + 1;
                }

                if(nx<0||ny<0||nx>=X||ny>=Y) continue;
                if(arr[ny][nx] == 'X') continue;
                if(dist[ny][nx] != -1) continue;

                dist[ny][nx] = dist[y][x] + 1;
                que.add(nx);
                que.add(ny);
            }
        }

        return -1;
    }
}