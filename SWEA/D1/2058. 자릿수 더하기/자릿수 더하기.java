import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        process();
    }

    static void process() throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        while(N > 0) {
            sum += N % 10;
            N /= 10;
        }

        System.out.println(sum);
        
    }
}