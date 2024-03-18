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
        String str = br.readLine();

        for(char c : str.toCharArray()) {
            sb.append((c -64) + " ");
        }

        System.out.println(sb.toString());
    }   
}