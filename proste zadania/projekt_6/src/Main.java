import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void fan(int []tab,int n)
    {
        for (int i =0; i<n-1; i+=2)
        {
            int mem = tab[i];
            tab[i] = tab[i+1];
            tab[i+1] = mem;
        }
    }

    public static void main(String[] args)
    {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("tab size:");
        n = scanner.nextInt();
        int[] tab = new int[n];
        for (int i =0; i<n; i++)
        {
            System.out.println("podaj "+i+" komórke tab");
            System.out.println("podaj "+i+" komórke tab");
            tab[i] = scanner.nextInt();
        }
        System.out.println("------------");
        fan(tab,n);

        for (int i =0; i<n; i++)
        {
            System.out.println(tab[i]);
        }

    }
}