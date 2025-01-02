import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static boolean[][] adj, reverseAdj;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new boolean[N+1][N+1];
        reverseAdj = new boolean[N+1][N+1];

        StringTokenizer st;
        int A, B;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            adj[A][B] = true;
            reverseAdj[B][A] = true;
        }        
    }

    public static void process(){
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    if(adj[j][i] && adj[i][k])
                        adj[j][k] = true;

                    if(reverseAdj[j][i] && reverseAdj[i][k])
                        reverseAdj[j][k] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                /*
                 * [OR 연산]
                 * adj[i][j] = adj[i][j] || reverseAdj[i][j];
                 * adj[i][j]가 true이거나, reverseAdj[i][j]가 true일 경우, adj[i][j]는 true
                 */
                adj[i][j] |= reverseAdj[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                // 자기 자신은 제외.
                if (i == j)
                    continue;
 
                // 무게 비교를 할 수 없을 경우
                if (!adj[i][j]) {
                    cnt++;
                }
            }
 
            sb.append(cnt + "\n");
        }

        System.out.println(sb.toString());
    }
}