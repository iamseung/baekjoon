import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 색종이의 갯수
		int N = Integer.parseInt(br.readLine());

		// 색종이 좌표를 찍어줄 array
		int[][] arr = new int[100][100];
		
		int count = 0;
	
		while(N-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			// 길이가 10이기 때문에 첫 좌표 ~ 첫 좌표 + 10까지 모든 좌표에 대한 체크 진행
			for(int a=X;a<X+10;a++)
			{
				// Y축도 마찬가지
				for(int b=Y;b<Y+10;b++)
				{
					// 중복이 돼도 1로 선언해주기 때문에 문제가 없음
					arr[a][b] = 1;
				}
			}	
		}
		
		// 좌표가 있는 부분을 체크해서 계산
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(arr[i][j] == 1) count++;
			}
		}
		
		System.out.print(count);
	}
}