import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] arr;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException{
        input();
        pro();
        output();
    }

    public static void input() throws IOException{
        N = Integer.parseInt(br.readLine()); // 도시
        M = Integer.parseInt(br.readLine()); // 버스
        arr = new int[N+1][N+1];

        // 자신 노드에서 자신 노드를 제외한 모든 정점의 값을 INF로 초기값 설정
        // INF의 의미는 해당 노드에서 특정 노드까지 가는 길이 없다는 뜻!
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;
                if (i == j)  arr[i][j] = 0;
            }
        }

        StringTokenizer st;
        int a,b,c;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            // 최소 비용을 저장
            arr[a][b] = Math.min(arr[a][b], c);
        }
    }

    public static void pro() {
        for(int i=1;i<=N; i++) {
            for(int j=1;j<=N; j++) {
                for(int k=1;k<=N; k++) {
                    // 한번에 가는 것보다 거쳐서 가는 비용이 더 적을 경우, 최단경로로 설정
                    if(arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }            
            }            
        }
    }
    public static void output() throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N; i++) {
            for(int j=1;j<=N; j++) {
                // 가는 길이 없다면 초기화
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }
                sb.append(arr[i][j]+" ");
            }            
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}