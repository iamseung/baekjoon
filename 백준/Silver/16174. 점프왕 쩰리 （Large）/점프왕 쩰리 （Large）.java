import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 1;
    static int[][] area;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1}};
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process() {
        BFS(0,0);
    }

    public static void BFS(int startX, int startY) {
        visit[startY][startX] = true;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(startX);
        Q.add(startY);

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            if(area[y][x] == -1) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            for(int k=0; k<2; k++) {
                int nx = x + dir[k][0] * area[y][x];
                int ny = y + dir[k][1] * area[y][x];

                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visit[ny][nx]) continue;

                Q.add(nx);
                Q.add(ny);

                visit[ny][nx] = true;
            }
        }

        System.out.println("Hing");
    }
}
