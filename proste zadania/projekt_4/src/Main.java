import java.util.*;

public class Main
 {
     public static void main(String[] args) {
         int i = 5;
         LinkedList<String> lista = new LinkedList<>();
         lista.add("test");
         lista.add("test1");
         for (String e : lista) {
             System.out.println(e);
         }
         System.out.println(lista.get(1));

         HashMap<Integer, String> mapa = new HashMap<>();
         mapa.put(1, "jedynka");
         mapa.put(2, "dwójka");
         mapa.put(3, "trójka");
         mapa.put(4, "czwórka");
         mapa.put(5, "piątka");
         mapa.put(6, "szustka");

         for (String s : mapa.values()) {
             System.out.println(s);
         }

         System.out.println(mapa.get(1));
         System.out.println("-------------- Przed posortowaniem");
         ArrayList<String> lista1 = new ArrayList<>();
         lista1.add("Poznań");
         lista1.add("Szczecin");
         lista1.add("Wrocław");
         lista1.add("Ełk");
         lista1.add("Warszawa");

         for (String e: lista1)
         {
             System.out.println(e);
         }
         System.out.println("-------------- Po posortowaniu");
         Collections.sort(lista1); //moetdy do sortownania (alfabetyczne)

         for (String e: lista1)
         {
             System.out.println(e);
         }
         System.out.println("-------------- Najmniejsza wartość");
         System.out.println(Collections.min(lista1)); //zwraca najemnijszą wartośc w kolekcji

         Collections.shuffle(lista1); //ustawia elemty listy w kolensći losowej


         System.out.println("-------------- praca na obiektach");

         ArrayList<Animal> koty = new ArrayList<Animal>();
         Animal kot1 = new Animal("Bury");
         Animal kot2 = new Animal("Czarny");
         Animal kot3 = new Animal("Biały");
         Animal kot4 = new Animal("Biały");
         kot4.wiek = 10;

         koty.add(kot1);
         koty.add(kot2);
         koty.add(kot3);
         koty.add(kot4);

         for(Animal kot : koty)
         {
             System.out.println(kot.name+" "+kot.wiek);
         }

     }
 }
