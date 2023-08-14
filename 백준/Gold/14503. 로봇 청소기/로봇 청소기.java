import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dir = {{-1,0},{0,1}, {1,0},{0,-1}};
    static int[][] map;
    static int N, M, sx, sy, way, time=1;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 좌표 생성
        N = Integer.parseInt(st.nextToken()); // Y좌표
        M = Integer.parseInt(st.nextToken()); // X좌표
        map = new int[N][M];

        // 시작 좌표 & 방향 설정
        st = new StringTokenizer(br.readLine(), " ");

        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        way = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void pro(){
        dfs(sx,sy,way);
        System.out.println(time);
    }

    // x, y, 방향
    static void dfs(int x, int y, int way) {
        // 청소를 했다는 의미
        map[y][x] = 2;

        for(int k=0; k<4; k++) {
            way -= 1; // 왼쪽 방향으로 탐색
            if(way == -1) way = 3;

            int nx = x + dir[way][1];
            int ny = y + dir[way][0];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(map[ny][nx] != 0) continue;

            time++;
            dfs(nx, ny, way);
            /*
             * 일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만
             * 이 문제는 후진할 때만 이전 길을 되돌아 가며 확인할 수 있으므로
             * return을 해서 다시 되돌아 와도 더 이상 움직이면 안된다!
             */
            return;
        }

        // 더 이상 청소할 공간이 없기 때문에 반복문을 빠져나온 상황
        // 반대방향으로 후진해야 한다
        int d = (way+2)%4; 
        int bx = x + dir[d][1];
        int by = y + dir[d][0];

        if(bx<0 || by<0 || bx>=M || by>=N || map[by][bx] == 1) return;
        // 후진할 때 방향 유지
        dfs(bx, by, way);
    }
}