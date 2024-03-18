import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {        
        process();

        System.out.println(sb.toString());
    }

    static void process() throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = IntStream.rangeClosed(0,N)
            .mapToObj(i -> (int) Math.pow(2, i))
            .collect(Collectors.toList());  
        
        for(int a : arr) sb.append(a+" ");
    }
}