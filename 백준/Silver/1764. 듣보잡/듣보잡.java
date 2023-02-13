import java.io.*;
import java.util.*;

public class Main 
{ 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		// N 집합
		HashMap<String, Integer> map = new HashMap<>();

		// 출력할 집합
		ArrayList<String> list = new ArrayList<>();

		while(N-- >0)
		{
			map.put(br.readLine(), 0);
		}
		
		while(M-- >0)
		{
			String key = br.readLine();

			// N 과 M 에 모두 있으면 list 에 추가하고 count + 1
			if(map.containsKey(key))
			{
				list.add(key);
				count++;
			}
		}

		// 사전순으로 출력해야 하니 정렬
		Collections.sort(list);

		// 출력
		System.out.println(count);

		for (String k : list)
        {
            System.out.println(k);
        }
		
	}
}