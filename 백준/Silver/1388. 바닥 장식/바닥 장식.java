import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, g, s;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] agrs) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        g = s = 0;
    }

    public static void process() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j]) {
                    BFS(j,i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static int BFS(int startX, int startY) {
        int cnt = 1;
        visit[startY][startX] = true;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(startX);
        Q.add(startY);

        // '|'
        int[] dir = new int[]{1,0};

        if(map[startY][startX] == '-') {
            dir[0] = 0;
            dir[1] = 1;
        }

        while(!Q.isEmpty()) {
            int x = Q.poll() + dir[1];
            int y = Q.poll() + dir[0];

            if(x<0 || y<0 || x>=M || y>=N) continue;
            if(visit[y][x]) continue;
            if(map[y][x] != map[startY][startX]) continue;

            cnt++;
            visit[y][x] = true;
            Q.add(x);
            Q.add(y);
        }

        return cnt;
    }

   
}