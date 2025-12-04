import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    public static void main(String[] args) {
        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("files/input.txt"))) {
            String prevLine = "";
            String currLine = reader.readLine();

            while (currLine != null) {
                String nextLine = reader.readLine();
                for (int i = 0; i < currLine.length(); i++) {
                    int count = 0;
                    if (currLine.charAt(i) == '@') {
                        for (int j = i - 1; j < i + 2; j++) {
                            if (j >= 0 && j < currLine.length()) {
                                if (!prevLine.isEmpty() && prevLine.charAt(j) == '@') count++;
                                if (currLine.charAt(j) == '@' && j != i) count++;
                                if (!(nextLine == null) && nextLine.charAt(j) == '@') count++;
                            }
                        }
                        if (count < 4) total++;
                    }
                }
                prevLine = currLine;
                currLine = nextLine;
            }

            System.out.println("Total: " + total);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
