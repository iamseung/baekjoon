import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] prime;
    static final int INF = 9_001;
    static int N, M;
    static int[] cows;
    static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cows = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cows[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        buildPrime();
        backTracking(0, 0, 0);

        if(answer.size() == 0) {
            System.out.println(-1);
            System.exit(0);   
        }
            
        int[] ans = answer.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int a : ans)
            sb.append(a + " ");

        System.out.println(sb.toString());
    }

    static void backTracking(int depth, int pickCount, int weightSum) {
        if (depth == N) {
            if (!prime[weightSum] && pickCount == M)
                answer.add(weightSum);

            return;
        }

        backTracking(depth + 1, pickCount + 1, weightSum + cows[depth]);
        backTracking(depth + 1, pickCount, weightSum);
    }

    static void buildPrime() {
        prime = new boolean[INF];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(INF); i++) {
            for (int j = 2; i * j <= INF; j++) {
                prime[i * j] = true; // 소수가 아님
            }
        }
    }
}