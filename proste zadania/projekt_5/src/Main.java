import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

public class Main
{
    public static void test(int a,String c)
    {
        for (int i = 0; i<a; i++)
        {
            System.out.println(c);
        }
    }


    public static void main(String[] args)
    {
        int a=5;
        String c = "aa";
        test(a,c);


        System.out.println("Hello world!");
        Queue<String> kolejka = new ArrayDeque<>();

        kolejka.add("1");
        kolejka.add("2");
        kolejka.add("3");
        kolejka.add("4");

        System.out.println(kolejka.peek());
        System.out.println(kolejka.remove());
        System.out.println(kolejka.poll()); //rombi to samo co remove ale nie rzuca wyjątku tylko wartość NULL kiiedy nie będze obiektów w stosioe

        Stack <String> stos  = new Stack<>();

    }
}