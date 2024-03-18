import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int N = 5;

    public static void main(String[] args) throws IOException {        
        process();

        System.out.println(sb.toString());
    }

    static void process() throws IOException {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==j) 
                    sb.append("#");
                else
                    sb.append("+");
            }

            sb.append("\n");
        }
    }
}