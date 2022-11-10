import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashMap;



public class Main 
{ 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		HashMap<Integer, Integer> map = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int count = 0;
		int S = N+M;
		st = new StringTokenizer(br.readLine(), " ");

		while(N-- >0)
		{
			map.put(Integer.parseInt(st.nextToken()), 0);
		}

		st = new StringTokenizer(br.readLine(), " ");

		while(M-- >0)
		{
			if(map.containsKey(Integer.parseInt(st.nextToken()))) count++;
		}

		System.out.println(S-2*count);
	}
}