import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());
    }

    static void process() {
        long sum = 0L;
        long CNT = 0L;
        for (int l = 1, r = 0; l <= N; l++) {
            sum -= arr[l - 1];

            while (r + 1 <= N && sum <= K) {
                sum += arr[++r];
            }

            // 현재 R 값보다 큰 좌표들도 모두 가능
            if (sum > K)
                CNT += N - r + 1;
        }

        System.out.println(CNT);
    }
}