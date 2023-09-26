import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,cheese,ANS;
    static int[][] area, dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit, meltingArea;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process() {
        int index = 0;

        while(true) {
            boolean erase = false;

            makeMeltingArea();

            visit = new boolean[N][M];

            cheese = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(area[i][j] == 1 && !visit[i][j]) {
                        erase = true;
                        DFS(j,i);
                    }
                }
            }

            if(!erase) break;

            ANS = cheese;
            index++;
        }

        System.out.println(index);
        System.out.println(ANS);
    }

    public static void DFS(int x, int y) {
        cheese++;
        visit[y][x] = true;

        if(isMelt(x, y)) area[y][x] = 0;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(area[ny][nx] == 0) continue;
            if(visit[ny][nx]) continue;
        }
    }

    public static void makeMeltingArea() {
        meltingArea = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Integer> Q = new LinkedList<>();

        Q.add(0);
        Q.add(0);

        meltingArea[0][0] = true;
        visited[0][0] = true;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(area[ny][nx] == 1) continue; // 치즈
                if(visited[ny][nx]) continue;

                Q.add(nx);
                Q.add(ny);

                visited[ny][nx]= true;
                meltingArea[ny][nx] = true;
                // System.out.println(ny+" "+nx);
            }
        }
    }

    // 녹일 수 있는지
    public static boolean isMelt(int x, int y) {
        boolean FLAG = false;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(area[ny][nx] == 1) continue; // 치즈
            if(meltingArea[ny][nx]) {
                FLAG = true;
                break;
            }
        }

        return FLAG;
    }
}