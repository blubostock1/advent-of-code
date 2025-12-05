import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solver {

    static class Range {
        long start, end;
        Range(long s, long e) { start = s; end = e; }
        boolean contains(long v) { return v >= start && v <= end; }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            int stage = 0;
            int count = 0;

            List<Range> fresh = new ArrayList<>();

            while (line != null) {
                if (stage == 0 && line.isEmpty()) {
                    stage = 1;
                } else if (stage == 0) {
                    String[] range = line.split("-");
                    long start = Long.parseLong(range[0]);
                    long end   = Long.parseLong(range[1]);
                    fresh.add(new Range(start, end));
                } else {
                    long v = Long.parseLong(line);
                    for (Range r : fresh) {
                        if (r.contains(v)) {
                            count++;
                            break;
                        }
                    }
                }
                line = reader.readLine();
            }

            System.out.println("Total: " + count);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
