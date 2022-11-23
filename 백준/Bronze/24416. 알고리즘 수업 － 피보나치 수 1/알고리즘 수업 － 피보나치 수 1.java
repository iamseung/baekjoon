import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	static int N1 = 0;
	static int N2 = 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fib(N);
		fibonacci(N);

		System.out.println(N1+ " " +N2);

	}

	public static int fib(int N)
	{
		if(N == 1 || N == 2)
		{
			N1++;
			return 1;
		}
		else
		{
			return fib(N-1) + fib(N-2);
		}
	}

	public static int fibonacci(int N)
	{
		int[] arr = new int[N+1]; // 0 ~ N까지 생성

		arr[1] = arr[2] = 1; // 3부터 생성하니까 0은 고려안해도 됨

		for(int i=3;i<=N;i++)
		{
			N2++;
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[N];
	}
}