import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // init
        map = new char[N][N]; visit = new boolean[N][N];

        // Mapping
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    // 장애물 : 1, 도로 : 0 / 장애물의 크기 구하기
    static void process() {
        List<Integer> count = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == '1' && !visit[i][j]) {
                    count.add(BFS(j,i));
                }
            }
        }

        Collections.sort(count);

        sb.append(count.size()+"\n");

        for(int t : count) sb.append(t+"\n");

        System.out.println(sb.toString());
    }

    static int BFS(int x, int y) {
        int CNT = 1;
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        que.add(y);
        visit[y][x] = true;

        while (!que.isEmpty()) {
            int qx = que.poll();
            int qy = que.poll();

            for(int k=0; k<4; k++) {
                int nx = qx + dir[k][0];
                int ny = qy + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[ny][nx]) continue;
                if(map[ny][nx] == '0') continue;

                que.add(nx);
                que.add(ny);
                visit[ny][nx] = true;


                CNT++;
            }
            
        }

        return CNT;
    }
}