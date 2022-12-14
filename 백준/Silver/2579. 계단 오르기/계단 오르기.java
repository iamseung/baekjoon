import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * [Top-Down]
 * 큰 문제를 호출하여 작은 문제로 호출하여 풀어나가는 방식
 * [Bottom-up]
 * 작은문제부터 풀어가며 전체를 풀어가는, 대개 반복문을 통해 구현
 */

public class Main
{
	static Integer dp[];
	static int arr[];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		dp  = new Integer[N+1];

		for(int i=1;i<=N;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}

		/*
		 * dp[]의 default 값이 null 이므로 
		 * 0으로 초기화 해주어야 한다.
		 */
		dp[0] = arr[0];
		dp[1] = arr[1];

		if(N >= 2) dp[2] = arr[1] + arr[2];

		System.out.println(find(N));
	}

	// 직전 칸은 밟은 상태인지 알 수 없기 때문에 arr 에서 호출을 진행
	static int find(int N)
	{
		if(dp[N] == null)
		{
			dp[N] = Math.max(find(N-2), find(N-3) + arr[N-1]) + arr[N];
		}

		return dp[N];
	}
}