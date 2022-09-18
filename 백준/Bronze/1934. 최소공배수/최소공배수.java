import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main 
{
	public static int T = 0;
	public static void main(String[] args) throws IOException 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		while(N-- >0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int gcdVal = gcd(A, B);
			System.out.println(A*B/gcdVal);
		}
	}
	
	// 최대공약수 함수
	static int gcd(int a, int b) 
	{
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}