import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String A, B;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken(); // ABCDD  , 5
        B = st.nextToken(); // ABCDDSS, 7
    }

    static void process() {
        int ANS = Integer.MAX_VALUE;
        for(int i=0; i<=B.length()-A.length(); i++) {
            int match = 0;
            for(int j=0; j<A.length(); j++) {
                if(B.charAt(i+j) != A.charAt(j)) match++;
            }

            ANS = Math.min(ANS, match);
        }

        System.out.println(ANS);
    }
}
