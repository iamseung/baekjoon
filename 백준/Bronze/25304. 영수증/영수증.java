import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0;i<N;i++)
		{
			String[] input = br.readLine().split(" ");
			sum += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
		}

		if(T == sum)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}