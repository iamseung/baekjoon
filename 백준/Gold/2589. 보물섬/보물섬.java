import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,ANS;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] area;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new char[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                area[i][j] = str.charAt(j);
                // System.out.println(area[i][j]);
            }
        }
    }

    public static void process() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 육지인 곳에서 제일 
                if(area[i][j] == 'L') {
                    BFS(j,i);
                }
            }
        }

        System.out.println(ANS);
    }

    public static void BFS(int x, int y) {
        int[][] dist = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);

        dist[y][x] = 0;

        while(!Q.isEmpty()) {
            int qx = Q.poll();
            int qy = Q.poll();

            for(int k=0; k<4; k++) {
                int nx = qx + dir[k][0];
                int ny = qy + dir[k][1];
                
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(area[ny][nx] != 'L') continue;
                if(dist[ny][nx] != -1) continue;

                Q.add(nx);
                Q.add(ny);

                dist[ny][nx] = dist[qy][qx] + 1;

                ANS = Math.max(ANS, dist[ny][nx]);
            }
        }


    }
}