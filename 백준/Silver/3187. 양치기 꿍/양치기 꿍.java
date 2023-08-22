import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main (String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new char[N][M];
        visit = new boolean[N][M];

        String str; 
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    // . => 빈공간
    // # => 울타리
    // v => 늑대
    // k => 양
    public static void process() {
        int wolf = 0;
        int sheep = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 빈 공간
                if(map[i][j] != '#' && !visit[i][j]) {
                    int[] temp = BFS(j,i);
                    sheep += temp[0];
                    wolf += temp[1];
                }
            }
        }

        System.out.println(sheep+" "+wolf);
    }

    public static int[] BFS(int startX , int startY) {
        int[] animals = new int[2];
        int wolf = (map[startY][startX] == 'v') ? 1 : 0;
        int sheep = (map[startY][startX] == 'k') ? 1 : 0;;

        // 방문 처리
        visit[startY][startX] = true;

        // 큐를 생성하고 탐색 시작
        Queue<Integer> Q = new LinkedList<>();
        Q.add(startX);
        Q.add(startY);

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(visit[ny][nx]) continue;
                if(map[ny][nx] == '#') continue;

                // 양 & 늑대 카운트
                if(map[ny][nx] == 'v') {
                    wolf++;
                } 
                else if (map[ny][nx] == 'k') {
                    sheep++;
                }

                // 후처리
                visit[ny][nx] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        if(sheep > wolf) {
            animals[0] = sheep;
        }
        else {
            animals[1] = wolf;
        }

        return animals;
    }
}