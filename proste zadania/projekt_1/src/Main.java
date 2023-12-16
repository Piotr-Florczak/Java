import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner odczyt = new Scanner(System.in);

        System.out.println("witaj w kalkulator \n ");

        System.out.println("podaj a:");
        var a = odczyt.nextInt(); //odczyt.netxint - odczyta wartość jako int (odczyt.nextLine - odczyta wartość jako string)
        System.out.println("podaj b:");
        var b = odczyt.nextInt();

        {
            System.out.println("suma=" + (a + b) + "\n");

            System.out.println("różnica=" + (a - b) + "\n");

            System.out.println("różnica=" + (a - b) + "\n");

            System.out.println("iloczyn=" + (a * b) + "\n");

            System.out.println("iloraz=" + (a / b) + "\n");
        }
    }

}