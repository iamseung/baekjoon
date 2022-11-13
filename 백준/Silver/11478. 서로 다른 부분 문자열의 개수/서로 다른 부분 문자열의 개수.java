import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main 
{ 
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 중복이 아닌 배열을 생성해야 하기 때문에 HashSet 사용
		HashSet<String> set = new HashSet<>();

		String S = br.readLine();
		
		for(int i=0;i<S.length();i++)
		{
			String name = "";

			for(int j=i;j<S.length();j++)
			{
				name +=S.substring(j, j+1);
				set.add(name);
			}

		}

		// 배열(HashSet)의 크기를 출력
		System.out.println(set.size());
	}

	
}