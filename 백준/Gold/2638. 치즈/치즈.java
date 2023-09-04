import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map, dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M, ANS;
    static boolean[][] Accessable, visited;
    public static void main(String[] args) throws IOException {    
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ANS = 0;
        while(true) {
            boolean deleted = false;
            visited = new boolean[N][M];

            // 유입되지 않는 지역을 선택
            // 공기인 구역에서 DFS 1회 호출 NotAccess = true
            // 이후에 치즈인 구역을 제외하면 유입되지 않는 지역!
            makeNotAccessArea();

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        deleted = true;
                        DFS(j,i);
                    }
                }
            }

            if(!deleted) break;
            ANS++;
        }

        System.out.println(ANS);
    }

    public static void makeNotAccessArea() {
        Accessable = new boolean[N][M];

        Queue<Integer> Q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 1회 탐색
                if(map[i][j] == 0) {
                    Q.add(j);
                    Q.add(i);
                    break;
                }
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(Accessable[ny][nx]) continue;
                if(map[ny][nx] == 1) continue;

                Q.add(nx);
                Q.add(ny);
                Accessable[ny][nx] = true;
            }
        }
    }

    public static void DFS(int x, int y) {
        visited[y][x] = true;

        if(check(x, y)) {
            map[y][x] = 0;
        }

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(map[ny][nx] == 0) continue;
            if(visited[ny][nx]) continue;
            
            DFS(nx, ny);
        }
    }

    // 공기와 3면 이상 닿아있는가
    public static boolean check(int x, int y) {
        int CNT = 0;
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(map[ny][nx] == 1) continue;
            if(!Accessable[ny][nx]) continue;
            CNT++;
        }

        return CNT >= 2;
    }
}