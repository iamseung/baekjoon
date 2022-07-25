import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();

        if(str >= 90 && str <= 100)
        {
            System.out.println("A");
        }
        else if(str >= 80 && str <= 89)
        {
            System.out.println("B");
        }
        else if(str >= 70 && str <= 79)
        {
            System.out.println("C");
        }
        else if(str >= 60 && str <= 69)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
	}
}