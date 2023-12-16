import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Main
{
    public static ArrayList<Student> db_students = new ArrayList<>();
    public static void clearConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }
    public static void addStudent()
    {
        clearConsole();
        int[] grades = new int[1];
        grades[0]=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----ADD STUDENT-----");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Gender:");
        System.out.println("   -> men-1");
        System.out.println("   -> women-2");
        System.out.println("   -> other-3");
        int gender=scanner.nextInt(); String gender_name = switch (gender)
        {
            case 1 -> "men";
            case 2 -> "women";
            case 3 -> "other";
            default -> "none";
        };
        scanner.nextLine();
        System.out.println("enter the class name");
        String class_name = scanner.nextLine();
        System.out.println("enter the student's age");
        int age = scanner.nextInt();
        db_students.add(new Student(name,gender_name, class_name,age));
    }
    public static void showStudentsList()
    {
        clearConsole();
        for(Student student : db_students)
        {
            System.out.println("----- "+student.getName()+" -----");
        }
    }
    public static void showStudentInformation(String student_name)
    {
        //clearConsole();
        int count =0;
        for (Student student : db_students)
        {
            count++;
            if (student.getName().equalsIgnoreCase(student_name))
            {
                System.out.println("----- "+student.getName()+" -----");
                System.out.println("płeć: "+student.getGneder());
                System.out.println("klasa: "+student.getKlasa());
                System.out.println("wiek: "+student.getOld());
                break;
            }
            else
            {
                if (db_students.size() == count){ System.out.println("No results for: "+student_name);}
            }
        }
    }

    public static void main(String[] args)
    {
        addStudent();
        addStudent();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("------------------");
        showStudentsList();
        System.out.print("type student's name: ");
        String studentName = scanner1.nextLine();
        showStudentInformation(studentName);
    }

}