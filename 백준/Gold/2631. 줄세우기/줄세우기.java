import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 1); // 각 최장 거리는 1씩

        int max = 0;
        for(int cur=0; cur<N; cur++) {
            for(int before=0; before<cur; before++) {
                if(arr[before] < arr[cur])
                    dp[cur] = Math.max(dp[cur], dp[before] + 1);
            }

            max = Math.max(max, dp[cur]);
        }
        
        System.out.println(N-max);
	}
}
