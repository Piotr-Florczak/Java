import java.io.IOException;
public class ConsoleClear
{
    public static void main(String[] args)
    {
        clearConsole();
    }

    public static void clearConsole()
    {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows"))
            { // Dla systemów Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // Dla systemów Unix/Linux
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}