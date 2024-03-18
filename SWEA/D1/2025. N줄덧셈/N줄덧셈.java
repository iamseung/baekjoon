import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int S;


    public static void main(String[] args) throws IOException {        
        process();

        System.out.println(S);
    }

    static void process() throws IOException {
        int N = Integer.parseInt(br.readLine());

        S = IntStream.rangeClosed(1, N)
            .map(i->i)
            .sum();
    }
}