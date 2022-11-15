import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
 
public class Main {
 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Integer> map;

		int T = Integer.parseInt(br.readLine());

		while(T-- >0)
		{
			int N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			

			while(N-- >0)
			{
				st = new StringTokenizer(br.readLine(), " ");
 
				st.nextToken();
				String C = st.nextToken();
				
				// getOrDefault = 값이 없으면 defaultValue(0) 를 반환
				map.put(C, map.getOrDefault(C, 0)+1);
			}
			
			int res = 1;

			// 종류 별로 안 입는 경우까지 포함해서 +1
			for(int K : map.values())
			{
				res *= (K+1);
			}

			// 둘 다 안 입는 경우는 제외해야 하기 때문에 -1
			sb.append(res-1 + "\n");
		}

		System.out.println(sb);
	}
}