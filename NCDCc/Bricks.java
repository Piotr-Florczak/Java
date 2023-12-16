
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class Bricks
{
    public static void main(String[] args)
    {
        boolean nobuild = false;
        int bricks_numberI=0;
        int bricks_numberII=0;
        int bricks_miss=0;
        int cannotbulild=0;
        int bulild=0;
        int instruction_number=0;

        var list = new ArrayList<String>();
        Queue<String> sque = new ArrayDeque<>();
        ArrayList<String> box = new ArrayList<>();
        ArrayList<String> memory = new ArrayList<>();
        Queue<List<String>> queueOfLists = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("0:[A-O]{4}");
        Pattern pattern1 = Pattern.compile("^[1-9]:[A-N]{4}$");

        HashMap<Integer,String> instrukcje = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            line = line.replace("\u202F", "");
            line = line.trim();
            Matcher matcher = pattern.matcher(line);
            Matcher matcher1 = pattern1.matcher(line);

            if (!(matcher.matches() || matcher1.matches()) ) {System.out.println("klops"); System.exit(0);}

            char chr = line.charAt(0);
            int number = Character.getNumericValue(chr);
            if (chr == '0')
            {
                box.add(line.substring(2,6));
            }
            else
            {
                if (instrukcje.containsKey(number))
                {
                    // TWORZYMY LISTE INSTRUKJI
                    String existingValue = instrukcje.get(number);
                    instrukcje.put(number, existingValue + ","+line.substring(2,6));
                }
                else
                {
                    instrukcje.put(number, line.substring(2, 6));
                    instruction_number ++;
                }

            }
        }
        scanner.close();

        if (box.size() > 10000000 ) {System.out.println("klops"); System.exit(0);}
        // ----------------ETAP I ----------------
        for (HashMap.Entry<Integer, String> entry : instrukcje.entrySet())
        {
            // ITERUJE PO INSTRUKCJI I SZUKA KLUCZA KTÓRY JEST PODIZELNY PRZEZ 3
            if (entry.getKey() % 3 == 0)
            {
                //ZAWARTOSC INSTRUCKJI PRZENOSIMY NA POMOCNICZĄ LISTE "," służy jako separator
                String str = instrukcje.get(entry.getKey());
                String[] strArray = str.split(",");
                list = new ArrayList<>(Arrays.asList(strArray));
                if (list.size() > 5000) {System.out.println("klops"); System.exit(0);}
                queueOfLists.add(list); //DODAJE DO KOLEJKI INSTRUKCJIE

            }
        }
        instrukcje.entrySet().removeIf(entry -> entry.getKey() % 3 == 0);
        int a = queueOfLists.size();
        for (int i =0; i<=a-1; i++)
        {
            sque.addAll(queueOfLists.remove());
            int b = sque.size();
            for (int j = 0; j<=b-1; j++)
            {
                if (box.contains(sque.peek()))
                {
                    bricks_numberI++;
                    memory.add(sque.peek());
                    box.remove(sque.remove());
                }
                else
                {
                    bricks_numberII -= memory.size();
                    bricks_miss ++;
                    box.addAll(memory);
                    nobuild = true;
                }
            }
            if (nobuild){cannotbulild ++;}
            else{bulild ++;}
            memory.clear();
            sque.clear();
        }
        // ----------------ETAP II ----------------
        for (HashMap.Entry<Integer, String> entry : instrukcje.entrySet())
        {
            // ITERUJE PO INSTRUKCJI I SZUKA KLUCZA
            //ZAWARTOSC INSTRUCKJI PRZENOSIMY NA POMOCNICZA LISTE
            String str = instrukcje.get(entry.getKey());
            String[] strArray = str.split(",");
            list = new ArrayList<>(Arrays.asList(strArray));
            if (list.size() > 5000) {System.out.println("klops"); System.exit(0);}
            queueOfLists.add(list); //DODAJE DO KOLEJKI INSTRUKCJIE
        }
        int aa = queueOfLists.size();
        for (int i =0; i<=aa-1; i++)
        {
            sque.addAll(queueOfLists.remove());
            int b = sque.size();
            for (int j = 0; j<=b-1; j++)
            {
                if (box.contains(sque.peek()))
                {
                    bricks_numberII++;
                    memory.add(sque.peek());
                    box.remove(sque.remove());
                }
                else
                {
                    bricks_numberII -= memory.size();
                    bricks_miss ++;
                    box.addAll(memory);
                    nobuild = true;
                }
            }
            if (nobuild){cannotbulild ++;}
            else{bulild ++;}
            memory.clear();
            sque.clear();
        }
        if (instruction_number > 1000){System.out.println("klops"); System.exit(0);}
        System.out.println(bricks_numberI);
        System.out.println(bricks_numberII);
        System.out.println(box.size());
        System.out.println(bricks_miss);
        System.out.println(bulild);
        System.out.println(cannotbulild);
        System.exit(0);
    }
}
