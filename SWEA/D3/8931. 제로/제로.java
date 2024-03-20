import java.util.*;
import java.io.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        int index = 1;

        while(T-- > 0) {
            Stack<Integer> S = new Stack<>();
            int N = Integer.parseInt(br.readLine());

            while(N-- > 0) {
                int A = Integer.parseInt(br.readLine());

                if(A == 0 && !S.isEmpty()) {
                    S.pop();
                    continue;
                }

                S.push(A);
            }
            
            int sum = S.stream()
                        .mapToInt(i->i)
                        .sum();

            sb.append("#" + index++ + " " + sum + "\n");
        }

        System.out.println(sb.toString());

	}
}