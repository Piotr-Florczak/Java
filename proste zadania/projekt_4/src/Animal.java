public class Animal implements Comparable<Animal>
{
    String name;
    int wiek = 5;
    public Animal(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Animal o)
    {
        return this.name.compareTo(o.name);
    }
}
