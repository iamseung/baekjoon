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
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			if(X == 0 && Y == 0) break;
			if( X % Y == 0) System.out.println("multiple");
			else if( Y % X == 0) System.out.println("factor");
			else System.out.println("neither");
		}	
	}	
}
