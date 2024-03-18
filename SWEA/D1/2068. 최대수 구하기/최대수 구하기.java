import java.io.*;
import java.util.*;

public class Solution {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;

        while(st.hasMoreTokens()) {
            max = Math.max(max, Integer.parseInt(st.nextToken()));
        }

        sb.append("#" + index++ + " " + max + "\n");
    }
}