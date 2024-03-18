import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] nums = {2,3,5,7,11};
    static int index = 1;

    public static void main(String[] args) throws IOException {        
        int T = Integer.parseInt(br.readLine());

        while (T -- >0) {
            process();
        }

        System.out.println(sb.toString());
    }

    static void process() throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        sb.append("#" + index++ + " ");

        for(int n : nums) {
            int cnt = 0;

            while(N % n == 0) {
                cnt++;
                N /= n;
            }

            sb.append(cnt+" ");
        }
        
        sb.append("\n");
    }
}