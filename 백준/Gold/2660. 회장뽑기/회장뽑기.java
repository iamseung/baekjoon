import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 987654321;
    static int N;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];

        // init
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;

                adj[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == -1 && B == -1)
                break;

            adj[A][B] = adj[B][A] = 1;
        }
    }

    static void process() {
        StringBuilder title = new StringBuilder();
        StringBuilder body = new StringBuilder();

        // 플로이드 와샬
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (adj[j][k] > adj[j][i] + adj[i][k])
                        adj[j][k] = adj[j][i] + adj[i][k];
                }
            }
        }

        int score = INF;
        int[] scoreArr = new int[N + 1];

        // 가장 큰 값 갱신
        for (int i = 1; i <= N; i++) {
            int S = 0;
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] != INF)
                    S = Math.max(S, adj[i][j]);
            }

            // i 의 친구 점수
            scoreArr[i] = S;
            score = Math.min(score, S);
        }

        title.append(score + " ");

        int equalScore = 0;
        for (int i = 1; i <= N; i++) {
            if (score == scoreArr[i]) {
                equalScore++;
                body.append(i + " ");
            }
        }

        title.append(equalScore + "\n");
        System.out.print(title.toString());
        System.out.println(body.toString());
    }
}