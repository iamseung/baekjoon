import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int count = 0;
		HashMap<String, Integer> map = new HashMap<>();

		while(N-- >0)
		{
			map.put(br.readLine(), 0);
		}

		while(M-- >0)
		{
			if(map.containsKey(br.readLine())) count++;
		}

		System.out.print(count);
	}
}