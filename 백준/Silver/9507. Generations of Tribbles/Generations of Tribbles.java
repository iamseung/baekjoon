import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void process() {
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        BigInteger[] dp = new BigInteger[max + 1];

        dp[0] = dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("4");

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]).add(dp[i - 3]).add(dp[i - 4]);
        }

        for (int a : arr) {
            System.out.println(dp[a]);
        }
    }
}