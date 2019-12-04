import java.util.*;

/**
 * The Solution of Day Two of Advent of Code. 
 * 
 * The Question can be found at: https://adventofcode.com/2019/day/2
 * @author seanlowjk
 */
public class DayTwo {

    // Not a good practice to declare global variables here. 
    public int[] original; 
    public int[] arr;
    public int instruction;

    public void run() {
        Scanner sc = new Scanner(System.in);
        instruction = 0;

        List<Integer> l = new ArrayList<>();

        String[] nums = sc.nextLine().split(",");
        
        for (String string : nums) {
            l.add(Integer.parseInt(string));
        }

        arr = new int[l.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = l.get(i);
        }

        original = Arrays.copyOf(arr, arr.length);

        arr[1] = 12;
        arr[2] = 2;
        tranverse();
        System.out.println(arr[0]);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                arr = Arrays.copyOf(original, original.length);
                arr[1] = i;
                arr[2] = j;

                tranverse();
                if (arr[0] == 19690720) {
                    System.out.println((i * 100) + j);
                    break;
                }
            }
        }

    }

    public void tranverse() {
        int counter = 0; 
        while (counter + 4< arr.length) {
            int op = execute(counter); 
            if (op == 0) {
                break;
            }

            counter += 4;
        }
    }

    public int execute(int counter) {
        int opCode = arr[counter];
        int left = arr[arr[counter + 1]];
        int right = arr[arr[counter + 2]];
        int dest = arr[counter + 3];
        if (opCode == 1) {
            arr[dest] = left + right;
            return 1;
        } else if (opCode == 2) {
            arr[dest] = left * right;
            return 2;
        } else if (opCode == 99) {
            return 0; 
        } else {
            return -1;
        }
    } 

    public static void main(String[] args) {
        DayTwo problem = new DayTwo();
        problem.run();
    }
}
