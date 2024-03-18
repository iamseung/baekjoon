import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {        
        process();
    }

    static void process() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String ANS = "";

        if(A == 1) {
            ANS = (B == 2) ? "B" : "A";
        } else if (A == 2) {
            ANS = (B == 1) ? "A" : "B";
        } else {
            ANS = (B == 2) ? "A" : "B";
        }

        System.out.println(ANS);
    }
}