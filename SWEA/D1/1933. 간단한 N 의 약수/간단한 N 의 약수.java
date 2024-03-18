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
        int A = Integer.parseInt(br.readLine());

        List<Integer> arr = IntStream.rangeClosed(1, A)
                        .filter(i-> A%i == 0)
                        .boxed()
                        .collect(Collectors.toList());
                    

        for(int a : arr) sb.append(a+" ");
    }
}