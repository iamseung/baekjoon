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
        
		/*
		 *  HashMap<Key, Value>
		 *  Key = 입력되는 원소
		 *  Value = 원소의 개수(=중복 입력 된 원소의 수) 
		 */
        
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) 
        {
			int key = Integer.parseInt(st.nextToken());
            
			/* 
			 * getOrDefault(key, defaultValue)
			 * key에 대해 map에 저장 된 value를 반환한다.
			 * 만약 value가 없을 경우 defaultValue값을 반환한다.
			 */
            
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) 
        {
			int key = Integer.parseInt(st.nextToken());
	
			sb.append(map.getOrDefault(key, 0)).append(' ');
		}
		
		System.out.println(sb);
	}
}