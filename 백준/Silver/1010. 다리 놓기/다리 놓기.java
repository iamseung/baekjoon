import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	static int[][] dp;
 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[30][30];
		while(T-- >0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			System.out.println(BC(K, N));
		}
	}
 
	// 이항계수 nCr
	static int BC(int n, int k) 
	{
		// 이미 풀었던 sub문제일 경우 값을 재활용
		if (dp[n][k] > 0) 
		{
			return dp[n][k];
		}
 
		// 2번 성질
		if (n == k || k == 0) 
		{
			return dp[n][k] = 1;
		}
 
		// 1번 성질, 2번 성질을 만족할 때까지 줄여가는 방식
		return dp[n][k] = BC(n - 1, k - 1) + BC(n - 1, k);
	}
}