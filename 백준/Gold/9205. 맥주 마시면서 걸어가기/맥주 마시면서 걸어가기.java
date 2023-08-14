import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T,N;
    static ArrayList<int[]> a;
    static boolean[][] isSearch;
    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            input();
            pro();
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        // 집,편의점,페스티벌 위치를 저장
        a = new ArrayList<>();

        int x,y;
        for(int i=0; i<N+2; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a.add(new int[]{x,y});
        }

        isSearch = new boolean[N+2][N+2];
    }

    public static void pro() {
        /**
         * 맨해튼 거리 1,000m 이하를 만족하는 두 정점을 찾음
         * 그 두 거리는 서로 연결되어 있다고 판단하고 경로 배열에 true 
         */
        for(int i=0; i<N+2; i++) {
            for(int j=i+1; j<N+2; j++) {
                if(isConnected(a.get(i), a.get(j))) {
                    isSearch[i][j] = isSearch[j][i] = true;
                }
            }
        }

        fload();

        // 0->N+1 은 연결되어 있는 지 확인
        sb.append((isSearch[0][N+1] ? "happy" : "sad") + "\n");
    }

    // 50m, 20병이기 때문에 거리제한은 1,000m
    public static boolean isConnected(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]) <= 1000;
    }

    /**
     * 플로이드 와샬 알고리즘
     * [i][k] && [k][j] 이면 i->k->j 는 연결되어있다!
    */
    public static void fload() {
        for(int k = 0; k < N + 2; k++) {
            for(int i = 0; i < N + 2; i++) {
                for(int j = 0; j < N + 2; j++) {
                    if(isSearch[i][k] && isSearch[k][j]) {
                        isSearch[i][j] = true;
                    }
                }
            }
        }
    }
}