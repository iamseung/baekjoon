import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static boolean[] isPrime = new boolean[1004001];

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process() {
        isPrime();
        while(true) {
            if(isPalindrom(N)) break;
            N++;
        }
        System.out.println(N);
    }

    public static void isPrime() {
        // 0과 1은 소수가 아님
        isPrime[0] = isPrime[1] = true;
        for(int i=2; i<=(int)Math.sqrt(1004000); i++) {
            for(int j=2; i*j<=1004000; j++) {
                // true : 소수가 아님
                isPrime[i*j] = true;
            }
        }
    }

    public static boolean isPalindrom(int K) {
        if(isPrime[K]) return false;

        String strX = Integer.toString(K);
        String rev = new StringBuilder(strX).reverse().toString();
        if(strX.equals(rev)) return true;

        return false;
    }
}