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
		StringBuilder sb = new StringBuilder();

		// 숫자를 찾기 위한 정규식
		String REGEX = "[0-9]+";

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// HashMap index 1부터 시작
		String[] arr = new String[N+1];

		HashMap<String, Integer> map = new HashMap<>();

		for(int i=1;i<N+1;i++)
		{
			String name = br.readLine();
			map.put(name, i);
			arr[i] = name;
		}

		while(M-- >0)
		{
			String str = br.readLine();
			
			// 입력값에 숫자가 있으면
			if(str.matches(REGEX))
			{
				sb.append(arr[Integer.parseInt(str)]+"\n");
			}
			else
			{
				sb.append((map.get(str))+"\n");
			}
		}

		System.out.println(sb);
	}
}