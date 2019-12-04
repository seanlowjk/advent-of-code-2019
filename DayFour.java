import java.util.*;

/**
 * The Solution of Day Four of Advent of Code. 
 * 
 * The Question can be found at: https://adventofcode.com/2019/day/4
 * @author seanlowjk
 */
public class DayFour {

    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split("-");

        int lowerBound = Integer.parseInt(nums[0]);
        int upperBound = Integer.parseInt(nums[1]);

        System.out.println(counterPartOne(lowerBound, upperBound));
        System.out.println(counterPartTwo(lowerBound, upperBound));
    }

    public int counterPartOne(int lowerBound, int upperBound) {
        int counter = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            if (check(i + "")) {
                counter ++;
            }
        }
        
        return counter;
    }

    public int counterPartTwo(int lowerBound, int upperBound) {
        int counter = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            if (secondCheck(i + "")) {
                counter ++;
            }
        }
        
        return counter;
    }

    public boolean check(String num) {
        boolean hasDuplicate = false;
        boolean hasDecrease = false;

        for (int i = 0; i < 5; i++) {
            char first = num.charAt(i);
            char second = num.charAt(i + 1);

            if (first == second) {
                hasDuplicate = true;
            }

            if (first > second) {
                hasDecrease = true;
            }
        }

        return hasDuplicate && !hasDecrease;
    }

    public boolean secondCheck(String num) {
        boolean hasDuplicate = false;
        boolean hasDecrease = false;

        for (int i = 0; i < 5; i++) {
            char first = num.charAt(i);
            char second = num.charAt(i + 1);

            if (first > second) {
                hasDecrease = true;
            }
        }

        hasDuplicate = checkLargerGroups(num);

        return hasDuplicate && !hasDecrease;
    }

    private boolean checkLargerGroups(String num) {
        for (int i = 0; i < 5; i++) {
            char first = num.charAt(i);
            char second = num.charAt(i + 1);

            if (first == second) {
                if (i == 0) {
                    if (num.charAt(i + 2) != second) {
                        return true;
                    }
                } else if (i == 4) {
                    if (num.charAt(i - 1) != first) {
                        return true;
                    }
                } else {
                    if (num.charAt(i - 1) != first && num.charAt(i + 2) != second) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DayFour problem = new DayFour();
        problem.run();
    }
}
