import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int S;


    public static void main(String[] args) throws IOException {        
        process();

        System.out.println(sb.toString());
    }

    static void process() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        sb.append(A + B + "\n");
        sb.append(A - B + "\n");
        sb.append(A * B + "\n");
        sb.append(Math.round(A / B) + "\n");
    }
}