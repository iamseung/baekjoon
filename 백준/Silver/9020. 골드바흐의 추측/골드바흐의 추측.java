import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static boolean[] prime = new boolean[10001];

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 소수 리스트 생성
		get_prime();

		// 입력할 수 받음
		int num = Integer.parseInt(br.readLine());

		for(int i=0;i<num;i++)
		{
			// 수 입력
			int N = Integer.parseInt(br.readLine());

			int min = Integer.MAX_VALUE;
			int minNum = 0;
			
			for(int j=2;j<=N/2;j++)
			{
				if(!prime[j])
				{
					if(!prime[N-j])
					{
						if(min > N-2*j)
						{
							min = N-2*j;
							minNum = j;
						}
					}
				}
			}
			sb.append(minNum+" "+(N-minNum)).append("\n");
		}
		System.out.print(sb);
	}

	public static void get_prime()
	{
		prime[0] = prime[1] = true;

		for(int i=2;i<=Math.sqrt(prime.length);i++)
		{
			if(prime[i]) continue;

			for(int j=i*i;j<prime.length; j+=i)
			{
				prime[j] = true;
			}
		}
	}
}