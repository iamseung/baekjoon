import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for (int i = 3; i < 251; i++) {
            // dp[n] = dp[n-1] + 2*dp[n-2];
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
        }

        String line = null;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            System.out.println(dp[n]);
        }

        br.close();
    }
}