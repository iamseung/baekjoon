import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main 
{
    public static void main(String[] args) throws IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

		// 입력값
		int N = Integer.parseInt(str[0]);

		// 상을 받는 사람 수 K
		int T = Integer.parseInt(str[1]);

		// 두번째 라인
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer arr[] = new Integer[N];

		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken()); 
		}

		Arrays.sort(arr, Collections.reverseOrder());
		System.out.print(arr[T-1]);
     }
}