import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++)
		{
			String[] input = br.readLine().split(" ");
			sb.append("Case #"+(i+1)+": "+input[0]+" + "+input[1]+" = "+(Integer.parseInt(input[0])+(Integer.parseInt(input[1])))).append("\n");
		}

		System.out.println(sb);
		
	}
}