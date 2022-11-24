import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main
{
	static int[][][] dp = new int[21][21][21]; // 20을 넘지 않기 때문에
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		

		loop:
		while(true)
		{
			st = new StringTokenizer(br.readLine());

			while(st.hasMoreTokens())
			{
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				if(a == -1 && b == -1 && c == -1)
				{
					break loop;
				}

				sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
			}
		}

		System.out.println(sb);
	}

	static int w(int a, int b, int c)
	{

		if(inRange(a,b,c) && dp[a][b][c] != 0)
		{
			return dp[a][b][c];
		}
		if(a<=0 || b<=0 || c<=0)
		{
			return 1;
		}
		if(a>20 || b>20 || c>20)
		{
			return dp[20][20][20] = (int)Math.pow(2,20);
		}
		else if(a<b && b<c)
		{
			return dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}

		return dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}

	/*
	 *  배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가
	 *  나올 수 있기 때문에 이를 체크를 해주기 위한 함수다.
	 */
	static boolean inRange(int a, int b, int c) 
	{
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}
}