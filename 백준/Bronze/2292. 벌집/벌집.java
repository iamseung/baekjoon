import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main
{
	public static void main(String[] args) throws IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		int i = 2;
		int k = 2;
		int j = 5;

		while(true)
		{
			if(input == 1)
			{
				System.out.println(input);
				break;
			}

			if(k <= input && input <= k+j)
			{
				System.out.println(i);
				break;
			}
			k = k+j+1;
			j += 6; 
			i++;
		}
	}
}