import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver2 {
    public static int total = 0;

    public static void main(String[] args) {
        // Reader
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            int currentPos = 50;

            while (line != null) {
                char direction = line.charAt(0);
                int moves = Integer.parseInt(line.substring(1, line.length()));

                int nextPos = getNextPos(currentPos, moves, direction);
                currentPos = nextPos;

                line = reader.readLine();
            }

            System.out.println(total);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static int getNextPos(int currentPosition, int moves, char direction) {
        for (int i = 0; i < moves; i++) {
            if (direction == 'L') {
                if (currentPosition == 0) {
                    currentPosition = 99;
                } else {
                    currentPosition--;
                }
            } else {
                if (currentPosition == 99) {
                    currentPosition = 0;
                } else {
                    currentPosition++;
                }
            }

            if (currentPosition == 0) total++;
        }
        return currentPosition;
    }
}
