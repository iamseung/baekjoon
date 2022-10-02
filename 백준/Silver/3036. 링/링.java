import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main 
{
	public static int T = 0;
	public static void main(String[] args) throws IOException 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int firstNum = Integer.parseInt(st.nextToken());
		int num;
		int share;
		int remainder;

		while(st.hasMoreTokens())
		{
			num = Integer.parseInt(st.nextToken());
			remainder = firstNum % num;
			share = firstNum / num;
			if(remainder == 0) System.out.println(share+"/1");
			else
			{
				int gcd = gcd(firstNum, num);
				System.out.println(firstNum/gcd+"/"+num/gcd);
			}
			
		}	
	}

	// 최대공약수 재귀 방식
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
            
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
}