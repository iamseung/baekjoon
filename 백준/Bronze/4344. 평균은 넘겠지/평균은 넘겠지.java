import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums  = Integer.parseInt(br.readLine()); // 첫째 라인
        
        int arr[];
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums;i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];

            double sum = 0;

            // 입력 한 줄에 대한 처리
            for(int j=0;j<N;j++)
            {
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val;
                sum += val;
            }
            
            double mean = (sum / N);
            double count = 0;
            for(int j=0;j<N;j++)
            {
                if(arr[j] > mean)
                {
                    count++;
                }
            }
            
            System.out.printf("%.3f%%\n", (count/N)*100);
                        
        }
        
    }
}