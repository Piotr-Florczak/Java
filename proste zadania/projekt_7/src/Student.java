public class Student
{
    private String name;
    private String gender;
    private String klasa;
    private int old;
    Student(String name,String gender,String klasa,int old)
    {
        this.name = name;
        this.gender = gender;
        this.klasa = klasa;
        this.old = old;
    }
    public String getName()
    {
        return this.name;
    }
    public String getGneder()
    {
        return this.gender;
    }
    public String getKlasa()
    {
        return this.klasa;
    }
    public int getOld()
    {
        return this.old;
    }



}
