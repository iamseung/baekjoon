import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,R;
    static int INF = 987654321;
    static int[][] distance;
    static int[] item;
    
    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

    public static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());   // 지역의 개수
        M = Integer.parseInt(st.nextToken());   // 수색범위
        R = Integer.parseInt(st.nextToken());   // 길이개수

        item = new int[N+1];                // 아이템 개수
        distance = new int[N+1][N+1];       // 거리

        // [init] 자기자신은 0, 연결되는 노드가 없는 경우엔 INF=>987654321
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                distance[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) item[i] = Integer.parseInt(st.nextToken());

        while(R-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = distance[b][a] = c;
        }
    }

    public static void pro() {
        // 최단 거리로 초기화
        fluid();
        
        int max = 0;
        int temp;
        for(int i=1; i<=N; i++) {
            temp = 0;
            for(int j=1; j<=N; j++) {
                if(distance[i][j] > M) continue;
                
                temp += item[j];
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }

    // j->k 를 가는 것보다 j->i->k 로 가는 비용이 적게든다면 초기화
    public static void fluid() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    if(distance[j][k] > distance[j][i] + distance[i][k]) {
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }
    }
}