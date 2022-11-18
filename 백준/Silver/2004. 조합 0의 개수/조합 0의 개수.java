import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main 
{ 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		// 입력 값이 20억이 넘기 대문에 long 사용
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		/*
		 * 누적합을 구하는 이유는 50!으로 예를 들면 50,45,40 .. 이렇게 5의 배수마다 5의 승수가 증가하기 때문에
		 * 1 - 50까지의 승수! 즉, 5의 배수가 반복되는 수의 합을 구하는 것이다.
		 */
 
		/*
		 * n!/(n-m)!m! 에 대한 승수를 아래와 같이 구한다.
		 */
		long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
		long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);

		// 2와 5 중의 최소 값 만큼 10이 만들어진다.
		System.out.println(Math.min(count5, count2));
	}
 
	// 5의 승수를 구하는 함수
	static long five_power_n(long num) 
	{
		int count = 0;
 
		while (num >= 5) 
		{
			count += (num / 5);
			num /= 5;
		}
		return count;
	}
 
	// 2의 승수를 구하는 함수
	static long two_power_n(long num) 
	{
		int count = 0;
 
		while (num >= 2) 
		{
			count += (num / 2);
			num /= 2;
		}
		return count;
	}
}