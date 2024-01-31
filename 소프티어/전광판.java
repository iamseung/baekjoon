import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String A, B;
    static String[] strs = {
        "1111110", // 0
        "0000110", // 1
        "1011011", // 2
        "1001111", // 3
        "0100111", // 4
        "1101101", // 5
        "1111101", // 6
        "1100110", // 7
        "1111111", // 8
        "1101111", // 9
        "0000000", // 빈칸
    };

    public static void main(String[] arg) throws IOException  {
        int K = Integer.parseInt(br.readLine());

        while(K-- > 0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    // A = String.format("%05d", Integer.parseInt(st.nextToken()));
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = String.format("%5s", Integer.parseInt(st.nextToken()));
        B = String.format("%5s", Integer.parseInt(st.nextToken()));
    }

    static void process() {
        int CNT = 0;
        for(int i=0; i<5; i++) {
            int aidx = A.charAt(i) == ' ' ? 10 : A.charAt(i) - '0';
            int bidx = B.charAt(i) == ' ' ? 10 : B.charAt(i) - '0';
            String str1 = strs[aidx];
            String str2 = strs[bidx];

            for(int j=0; j<7; j++) {
                if(str1.charAt(j) != str2.charAt(j)) CNT++;
            }
        }

        sb.append(CNT+"\n");
    }
}