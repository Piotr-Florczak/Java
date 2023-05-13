import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {
        Animal pies = new Animal("hałhał");
        Animal wilk = new Animal("ałuuuuuu");
        Animal kot = new Animal("miał");

        ArrayList lista = new ArrayList();
        lista.add(pies); lista.add(wilk); lista.add(kot);
        System.out.println("-----------------------");
        for(Object j : lista)
        {
            System.out.print("        ");
            System.out.println(((Animal)j).getImie());
        }
        System.out.println("-----------------------");
    }
}