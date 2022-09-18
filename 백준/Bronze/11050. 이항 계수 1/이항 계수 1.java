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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int G = 1;
		int D = 1;

		for(int i =0 ;i<B;i++)
		{
			G *= (A-i);
		}

		while(B > 0)
		{
			D *= B;
			B--;
		}
		System.out.println(G/D);
	
	}
}