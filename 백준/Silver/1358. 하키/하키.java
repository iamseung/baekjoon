import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main 
{
	public static int T = 0;
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int S = 0;
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int R = H/2;

		while(P-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 1.좌표가 X 보다 작은 경우
			if(A <= X)
			{
				if(Math.pow(A-X,2) + Math.pow(B-(Y+R),2) <= Math.pow(R,2)) S++; continue;
			}
			// 2.좌표가 X 보다 크고 X+W 보다 작은 경우
			else if(A > X && A < X+W)
			{
				if(Y <= B && B <= Y+H) S++; continue;
			}
			// 3.좌표가 X+W 보다 큰 경우
			else if(A >= X+W)
			{
				if(Math.pow(A-(X+W),2) + Math.pow(B-(Y+R),2) <= Math.pow(R,2)) S++; continue;
			}
		}
		System.out.print(S);
	}	
}
