import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JButton button = new JButton("Open File Chooser");
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(textPane);

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                counterService(selectedFile.getAbsolutePath(), textPane);
            }
        });
        frame.getContentPane().add(button, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void counterService(String path, JTextPane textPane) {
        Map<String, Integer> ordersCounter = new HashMap<>();
        Map<String, Integer> maxOrderSize = new HashMap<>();

        String[] cities = {"Gniezno", "Malbork", "Ogrodzieniec", "Przemysl"};
        for (String city : cities) {
            ordersCounter.put(city, 0);
            maxOrderSize.put(city, 0);
        }
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine(); // Pomiń nagłówek
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");

                String city = data[2];
                int orderSize = Integer.parseInt(data[3]);

                ordersCounter.put(city, ordersCounter.get(city) + 1);

                if (orderSize > maxOrderSize.get(city)) {
                    maxOrderSize.put(city, orderSize);
                }
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas czytania pliku: " + e.getMessage());
            return;
        }
        StringBuilder content = new StringBuilder("<html>");
        for (String city : cities) {
            content.append("Magazyn ").append(city).append(" złożył <b>").append(ordersCounter.get(city)).append("</b> zamówień.<br>");
        }
        for (String city : cities) {
            content.append("Największe zamówienie dla ").append(city).append(" wynosi: <b>").append(maxOrderSize.get(city)).append("</b><br>");
        }
        content.append("</html>");
        textPane.setText(content.toString());
    }
}
