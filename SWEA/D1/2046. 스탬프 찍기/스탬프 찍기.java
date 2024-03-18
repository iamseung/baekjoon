import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        process();
    }

    static void process() throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            sb.append("#");
        }

        System.out.println(sb.toString());
    }   
}