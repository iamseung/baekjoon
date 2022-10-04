import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[N][2];

		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int j=0;j<N;j++)
		{
			int M = N;
			int result=1;
			while(M-- > 0)
			{
				// 모든 경우의 수를 탐색하며 본인보다 큰 사람의 경우에만 ++
				if(arr[j][0] < arr[M][0])
				{
					if(arr[j][1] < arr[M][1]) result++;
				}
			}
			sb.append(result+" ");
		}
		System.out.println(sb);
	}
}