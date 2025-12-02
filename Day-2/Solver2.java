import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solver2 {
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

                    for (int j = 1; j <= stringVersion.length() / 2; j++) {

                        if (stringVersion.length() % j == 0) {
                            String[] parts = new String[stringVersion.length() / j];
                            int index = 0;
                            int count = 0;

                            while (index < stringVersion.length()) {
                                int finalIndex = index + j;
                                parts[count] = stringVersion.substring(index, finalIndex);
                                count++;
                                index = finalIndex;
                            }

                            boolean isValid = true;
                            for (int l = 1; l < parts.length; l++) {
                                if (!parts[l-1].equals(parts[l])) isValid = false;
                            }

                            if (isValid) {
                                total += i;
                                break;
                            }
                        }
                   }
                }
            }

            System.out.println("Total: " + total);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
