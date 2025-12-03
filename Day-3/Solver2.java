import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Solver2 {
    public static void main(String[] args) {

        long total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String result = "";
                int countAdded = 0;
                int currIndex = 0;

                while (countAdded != 12) {
                    for (int i = currIndex; i < line.length() - (11 - countAdded); i++) {
                        boolean isBigger = false;
                        for (int j = i; j < line.length() - (11 - countAdded); j++) {
                            if (Integer.parseInt(line.charAt(j) + "") > Integer.parseInt((line.charAt(i)) + "")) isBigger = true;
                        }
                        if (!isBigger) {
                            result += line.charAt(i);
                            countAdded++;
                        }

                        if (countAdded == 12) break;
                    }
                    currIndex = line.length() - (11 - countAdded);
                }
                total += Long.parseLong(result);
                line = reader.readLine();
            }

            System.out.println("Total: " + total);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
// 654