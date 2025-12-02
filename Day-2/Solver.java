import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    public static void main(String[] args) {
        long total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            String[] ranges = line.split(",");

            for (String range : ranges) {
                long first = Long.parseLong(range.split("-")[0]);
                long second = Long.parseLong(range.split("-")[1]);
                for (long i = first; i <= second; i++) {
                    String stringVersion = String.valueOf(i);
                    String firstHalf = stringVersion.substring(0, stringVersion.length() / 2);
                    String secondHalf = stringVersion.substring((stringVersion.length() / 2), stringVersion.length());
                    if (firstHalf.equals(secondHalf) && stringVersion.length() % 2 == 0) {
                        total += i;
                    }
                }
            }

            System.out.println("Total: " + total);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
