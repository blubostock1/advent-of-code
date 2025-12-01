import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solver {
    public static void main(String[] args) {
        // Reader
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            int currentPos = 50;
            int count = 0;

            while (line != null) {
                char direction = line.charAt(0);
                int moves = Integer.parseInt(line.substring(1, line.length()));

                int nextPos = getNextPos(currentPos, moves, direction);
                currentPos = nextPos;
                if (nextPos == 0) count++;
                System.out.println(currentPos);

                line = reader.readLine();
            }

            System.out.println(count);

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
        }
        return currentPosition;
    }
}
