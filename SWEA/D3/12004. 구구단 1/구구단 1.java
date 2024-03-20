import java.util.*;
import java.io.*;

public class Solution {
    static boolean[] ref = new boolean[101];
    static int[] selected = new int[2];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        int index = 1;
        
        rec(0);

        while(T-- > 0) {
            int A = Integer.parseInt(br.readLine());

            sb.append("#" + index++ + " " + (ref[A] ? "Yes" : "No") + "\n");
        }
        
        System.out.println(sb.toString());

	}

    static void rec(int k) {
        if(k == 2) {
            int sum = 1;
            for(int s : selected) {
                sum *= s;
            }

            ref[sum] = true;
            return;
        }

        for(int cur=1; cur<=9; cur++) {
            selected[k] = cur;

            rec(k+1);

            selected[k] = 0;
        }
    }
}