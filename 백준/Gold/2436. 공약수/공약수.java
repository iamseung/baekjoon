import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int gcd, lcd;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        gcd = Integer.parseInt(st.nextToken()); // 최대공약수
        lcd = Integer.parseInt(st.nextToken()); // 최소공배수
    }

    static void process() {
        /*
         * 두수를 곱하고 최대공약수로 나누면 최소공배수
         * a*b/A = B
         */
        int a = 0, b = 0;
        long mul = (long) gcd * lcd;

        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0 && getGcd(i, mul / i) == gcd) {
                a = i;
                b = (int) (mul / i);
            }
        }

        System.out.println(a + " " + b);
    }

    static long getGcd(long max, long min) {
        if (min == 0)
            return max;

        return getGcd(min, max % min);
    }
}