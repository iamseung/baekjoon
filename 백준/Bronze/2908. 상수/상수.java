import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int Aone = A / 100;
        int Atwo = (A % 100)/10;
        int Athree = A % 10;

        int Bone = B / 100;
        int Btwo = (B % 100)/10;
        int Bthree = B % 10;

        int C = Athree * 100 + Atwo * 10 + Aone;
        int D = Bthree * 100 + Btwo * 10 + Bone;
        
        if(C < D)
        {
            System.out.println(D);
        }
        else
        {
            System.out.println(C);
        }
    }
}