import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static int N, len;
    static int[] list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        makePrime();
        int sum = 0, r = 0, cnt = 0;
        for (int l = 1; l <= len; l++) {
            sum -= list[l - 1];

            while (r + 1 <= len && sum < N) {
                sum += list[++r];
            }

            if (sum == N)
                cnt++;
        }

        System.out.println(cnt);

    }

    static void DFS() {
        // 3 4 5, len = 3
        for (int i = 0; i <= len; i++)
            System.out.println(list[i]);
    }

    // 소수 구하기
    static void makePrime() {
        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            for (int j = 2; i * j <= N; j++) {
                // 소수가 아님
                prime[i * j] = true;
            }
        }

        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i])
                p.add(i);
        }

        len = p.size();

        list = new int[len + 1];
        for (int i = 1; i <= len; i++)
            list[i] = p.get(i - 1);

    }
}