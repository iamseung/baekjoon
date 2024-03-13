import java.util.*;

class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    static char[][] map;
    static boolean[][] visit;
    static int X, Y;
    
    public int[] solution(String[] maps) {
        List<Integer> ANS = new ArrayList<>();

        Y = maps.length;
        X = maps[0].length();

        map = new char[Y][X];
        visit = new boolean[Y][X];

        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++)
                map[i][j] = maps[i].charAt(j);
        }

        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++) {
                if(map[i][j] != 'X' && !visit[i][j]) {
                    ANS.add(bfs(i,j));
                }
            }
        }

        if(ANS.size() == 0 ) {
            return new int[]{-1};
        }

        Collections.sort(ANS);
        return ANS.stream()
                .mapToInt(i->i)
                .toArray();
    }
    
    static int bfs(int y, int x) {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(x); que.add(y);
        visit[y][x] = true;
        cnt += map[y][x] - 48;

        while(!que.isEmpty()) {
            int _x = que.poll();
            int _y = que.poll();

            for(int k = 0; k < 4; k++) {
                int qx = _x + dir[k][0];
                int qy = _y + dir[k][1];

                if(qx < 0 || qy < 0 || qx >= X || qy >= Y) continue;
                if(visit[qy][qx]) continue;
                if(map[qy][qx] == 'X') continue;

                cnt += map[qy][qx] - 48;

                que.add(qx);
                que.add(qy);

                visit[qy][qx] = true;
            }
        }

        return cnt;
    }
}