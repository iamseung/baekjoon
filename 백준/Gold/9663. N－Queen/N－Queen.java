import java.io.*;
import java.util.*;

public class Main 
{
    static int N;
    static int[] Ches;
    static int ans = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Ches = new int[N+1];
        
        rec_func(1);

        System.out.println(ans);
    }

    // 계산로직
    static void rec_func(int row)
    {
        // N+1까지 모두 탐색
        // N+1까지 좌표를 모두 찍었다면 count
        if(row == N+1)
        {
            ans++;
        }
        else
        {
            // [1-N까지 탐색하는 로직]
            // row(현재열), 1 .. N 까지 탐색
            for(int c=1;c<=N;c++)
            {
                boolean possible = true;

                // [row,c 검증]
                // 현재보다 위에 찍힌 좌표들을 확인하여 row, c 를 찍어도 되는 지 확인
                for(int i=1; i<=row-1;i++)
                {
                    // int r1, int c1, int r2, int c2
                    if(attackable(row, c, i, Ches[i]))
                    {
                        possible = false;
                        break;
                    }
                }
                
                // 찍어도 된다면 찍고 다음칸으로 이동
                if(possible)
                {
                    Ches[row] = c;
                    rec_func(row+1);
                    Ches[row] = 0;
                }
            }
        }

    }

    // 좌표를 찍을 때 공격 가능 여부를 확인
    static boolean attackable(int r1, int c1, int r2, int c2)
    {
        // (r1,c1) (r2,c2)
        
        // 같은 y열
        if(c1 == c2) return true;
        // 왼쪽 대각선
        if(r1-c1 == r2-c2) return true;
        // 오른쪽 대각선
        if(r1+c1 == r2+c2) return true;

        return false;
    }

}