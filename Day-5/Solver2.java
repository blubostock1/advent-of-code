import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solver2 {

    static class Range {
        long start, end;
        Range(long s, long e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        List<Range> ranges = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] r = line.split("-");
                long start = Long.parseLong(r[0]);
                long end   = Long.parseLong(r[1]);
                ranges.add(new Range(start, end));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return;
        }

        // 1. Sort by starting point
        Collections.sort(ranges, Comparator.comparingLong(a -> a.start));

        // 2. Merge overlaps
        long total = 0;
        long curStart = ranges.get(0).start;
        long curEnd   = ranges.get(0).end;

        for (int i = 1; i < ranges.size(); i++) {
            Range r = ranges.get(i);

            if (r.start <= curEnd + 1) {
                // overlap → extend current interval
                curEnd = Math.max(curEnd, r.end);
            } else {
                // no overlap → commit previous interval
                total += (curEnd - curStart + 1);
                curStart = r.start;
                curEnd = r.end;
            }
        }

        // commit final interval
        total += (curEnd - curStart + 1);

        System.out.println("Total: " + total);
    }
}
