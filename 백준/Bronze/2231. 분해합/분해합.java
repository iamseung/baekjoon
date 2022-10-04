import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int m = 0;

		for(int i=1; i<N; i++)
		{
			int number = i;
			int sum = 0;

			while(number != 0)
			{
				sum += number % 10; // 나머지, 일의 자릿수부터
				number /= 10; // 몫
			}

			if(sum + i == N)
			{
				m = i;
				break;
			}
		}

		System.out.println(m); 
	}
}