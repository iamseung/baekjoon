import java.util.*;
import java.io.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        int index = 1;

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int min = Math.min(A,B);
            int max = Math.max(A,B);

            int sum = (C/min) + (C%min)/max;

            sb.append("#" + index++ + " " + sum + "\n");
        }

        System.out.println(sb.toString());

	}
}