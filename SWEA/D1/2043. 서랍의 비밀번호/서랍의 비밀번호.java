import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        process();
    }

    static void process() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken()); // 123
        int K = Integer.parseInt(st.nextToken()); // 100

        if(K > P) 
            P += 1000;
        

        System.out.println(P - K + 1);
    }   
}