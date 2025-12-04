import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solver2 {
    public static void main(String[] args) {
        int total = 0;
        String inputFile = "files/input.txt";
        int iterations = 0;
        int prevRemoved = 0;
        
        int removed = readAndWrite(inputFile, "files/output" + iterations + ".txt");
        while (prevRemoved != 0 || iterations == 0) {
            prevRemoved = removed;
            total += prevRemoved;
            removed = readAndWrite("files/output" + iterations + ".txt", "files/output" + (iterations + 1) + ".txt");
            iterations ++;
        }
        System.out.println("Total Removed: " + total);

    }

    public static int readAndWrite(String inputFile, String outputFile) {
        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String prevLine = "";
            String currLine = reader.readLine();
            String finalLine = "";

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
                        if (count < 4) {
                            finalLine += "x";
                            total++;
                        } else {
                            finalLine += "@";
                        }
                    } else {
                        finalLine += ".";
                    }
                }
                writer.write(finalLine);
                writer.newLine();
                prevLine = currLine;
                currLine = nextLine;
                finalLine = "";
            }
            
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return total;
    }
}
