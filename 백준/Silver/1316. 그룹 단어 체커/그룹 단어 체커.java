import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i=0;i<C;i++)
		{
			String str = br.readLine();
			Boolean B = true;

			loop:
			for(int j=0;j<str.length();j++)
			{
				int k = j;
				Boolean check = true;
					
				while(k+1 != str.length())
				{
					if(str.charAt(j) != str.charAt(k+1))
					{
						check = false;
						k++;
					}

					else
					{
						k++;

						if(check == false)
						{
							B = false;
							break loop;
						}
					}
				}
			}
			if(B){result++;}
		}
		System.out.print(result);
	}
}