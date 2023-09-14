import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,A,B,ANS;
    static int[][] dist;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {    
        input();
        process();
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 모든 정점 초기화
        dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                dist[i][j] = INF;
            }
        }
        // 학생의 키 순서를 아는 경우 1로 거리 배열 입력
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
        }
    }

    public static void process() {
        // 특정 학생이 모든 학생과의 거리를 체크해야 하므로 플로이드 워셜 수행
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dist[i][j]  = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }   
        }

        /*
         * 모든 학생과의 비교가 가능한 경우
         * => 거리가 INF가 아닌 학생의 수가 N-1인 경우 : 키가 몇번째인지 알 수 있음!
         */
        ANS = 0;
        for(int i=1; i<=N; i++) {
            int CNT = 0;
            for(int j=1; j<=N; j++) {
                if(dist[i][j] != INF || dist[j][i] != INF) CNT++;
            }

            if(CNT == N-1) ANS++;
        }

        System.out.println(ANS);
    }
}