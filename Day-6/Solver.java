import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solver {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            List<String[]> list = new ArrayList<>();

            int totalCols = 0;
            int totalRows = 0;
            long bigTotal = 0;

            while (line != null) {
                String[] parts = line.trim().split("\\s+");
                list.add(parts);
                totalCols++;
                totalRows = parts.length;
                line = reader.readLine();
            }

            int index = 0;
            while (index < totalRows) {
                String method = list.get(totalCols - 1)[index];
                long total = 0;
                if (method.equals("*")) total = 1;

                for (int i = 0; i < totalCols - 1; i++) {
                    if (method.equals("*")) total = total * Integer.parseInt(list.get(i)[index]);
                    else total += Integer.parseInt(list.get(i)[index]);
                }

                bigTotal += total;

                index++;
            }

            System.out.println("Total: " + bigTotal);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
