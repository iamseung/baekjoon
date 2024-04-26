import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A,B;
    
    public static void main(String[] args) throws IOException {
        input();
        simulate();
    }

    static void input() throws IOException  {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
    }
    
    static void simulate() {
        long gcd = gcd(A, B);
        System.out.println(A*B/gcd);
    }

    static long gcd(long A, long B) {
        while (B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }

        return A;
    }
}