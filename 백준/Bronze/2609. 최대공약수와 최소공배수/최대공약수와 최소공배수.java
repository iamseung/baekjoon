import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class Main 
{
	public static int T = 0;
	public static void main(String[] args) throws IOException 
	{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
 
		int d = gcd(a, b);	// 최대공약수
 
		System.out.println(d);
		System.out.println(a * b / d);
 
	}
 
	// 최대공약수 재귀 방식
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
            
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
}
