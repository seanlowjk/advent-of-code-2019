import java.util.*;
import java.math.*;

/**
 * The Solution of Day One of Advent of Code. 
 * 
 * The Question can be found at: https://adventofcode.com/2019/day/1
 * @author seanlowjk
 */
public class DayOne {

    public void run() {
        Scanner sc = new Scanner(System.in);

        long partOneAnswer = 0;
        long partTwoAnswer = 0;

        while (sc.hasNext()) {
            int n = sc.nextInt();
            partOneAnswer += getNum(n);
            partTwoAnswer += getNumPartTwo(n);
        }

        System.out.println(partOneAnswer);
        System.out.println(partTwoAnswer);

    }

    public int getNum(int x) {
        return ((int) (x / 3)) - 2;
    }

    public long getNumPartTwo(int x) {
        long answer = 0;

        while (x >= 0) {
            x = getNum(x);
            if (x <= 0) {
                return answer;
            }

            answer += x;
        }

        return answer;
    }

    public static void main(String[] args) {
        DayOne problem = new DayOne();
        problem.run();
    }
}
