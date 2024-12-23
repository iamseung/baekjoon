import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int X, Y;
    static int[][] map;
    static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
    static boolean[][] visited, top;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[Y][X];

        for(int i=0; i<Y; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<X; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process(){
        top = new boolean[Y][X];

        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++) {
                if(!top[i][j] && map[i][j] > 0) {
                    bfs(j, i);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        visited = new boolean[Y][X];
        visited[y][x] = true;
        
        Queue<int[]> que = new LinkedList<>();      // 검증 큐
        Queue<int[]> topList = new LinkedList<>();  // 산봉우리 큐

        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int k=0; k<dir.length; k++) {
                int nx = curX + dir[k][0];
                int ny = curY + dir[k][1];

                if(!isValid(nx, ny))
                    continue;

                // 시작점보다 높은 값이 있는 경우, 해당 좌표는 산봉우리가 아니므로 종료
                if(map[ny][nx] > map[curY][curX])
                    return;

                // 인접한 격자 중 높이가 같은 경우, 탐색할 요소에 추가
                if(map[ny][nx] == map[curY][curX]) {
                    que.add(new int[]{nx, ny});
                    topList.add(new int[]{nx, ny});
                }

                visited[ny][nx] = true;
            }

            while (!topList.isEmpty()) {
                int[] t = topList.poll();
                top[t[1]][t[0]] = true;
            }
        }

        cnt++;
    }

    static boolean isValid(int nx, int ny) {
        if(nx < 0 || ny < 0 || nx >= X || ny >= Y)
            return false;

        if(map[ny][nx] == 0)
            return false;

        if(visited[ny][nx])
            return false;

        return true;
    }
}