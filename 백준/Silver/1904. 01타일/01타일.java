import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static int[] dp = new int[1000001];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(returnDp(N));
	}

	public static int returnDp(int N)
	{
		if(dp[N] != 0)
		{
			return dp[N];
		}

		return dp[N] = (returnDp(N-1) + returnDp(N-2)) % 15746;
	}
}