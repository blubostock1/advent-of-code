import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Solver {
    public static void main(String[] args) {

        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                int max = 0;
                for (int i = 0; i < line.length() - 1; i++) {
                    for (int j = i + 1; j < line.length(); j++) {
                        int digit = Integer.parseInt(line.charAt(i) + "" + line.charAt(j));
                        if (digit > max) max = digit;
                    }
                }
                total += max;
                line = reader.readLine();
            }

            System.out.println("Total: " + total);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
