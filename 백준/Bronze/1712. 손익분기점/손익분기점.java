import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		String arr[] = input.split(" ");

		int X = Integer.parseInt(arr[0]);
		int Y = Integer.parseInt(arr[1]);
		int Z = Integer.parseInt(arr[2]);

		int i = 1;

		if(Z<=Y)
		{
			System.out.println(-1);
		}
		else{
			while(true)
			{
				if(X < (Z-Y)*i)
				{
					System.out.println(i);
					break;
				}
				i++;
			}
		}
	}
}