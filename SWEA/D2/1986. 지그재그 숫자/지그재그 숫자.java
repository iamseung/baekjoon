import java.io.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int index = 1;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            pro();
        }

        System.out.println(sb.toString());
    }

    static void pro() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int sum = IntStream.rangeClosed(1, N)
                    .map(i -> (i%2 == 0) ? i*-1 : i)
                    .sum();
        sb.append("#"+index++ +" " +sum+"\n");
    }
}