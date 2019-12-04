import java.util.*;

/**
 * The Solution of Day Three of Advent of Code. 
 * 
 * The Question can be found at: https://adventofcode.com/2019/day/3
 * @author seanlowjk
 */
public class DayThree {

    public void run() {
        Scanner sc = new Scanner(System.in);

        String[] wireOne = sc.nextLine().split(",");
        String[] wireTwo = sc.nextLine().split(",");

        List<Point> pointsWireOne = getPoints(wireOne);
        List<Point> pointsWireTwo = getPoints(wireTwo);

        List<Point> intersections = getIntersections(pointsWireOne, pointsWireTwo);

        Collections.sort(intersections);

        System.out.println(intersections.get(1).getDistance());

        List<Integer> distances = calculateWireDistances(wireOne, wireTwo, intersections);

        Collections.sort(distances);

        System.out.println(distances.get(1));
    }

    public List<Point> getIntersections(List<Point> pointsWireOne, List<Point> pointsWireTwo) {

        List<Point> intersections = new ArrayList<>();

        for (Point p1 : pointsWireOne) {
            for (Point p2 : pointsWireTwo) {
                if (p1.x == p2.x && p1.y == p2.y) {
                    intersections.add(p1);
                }
            }
        }

        return intersections;
    }

    public List<Point> getPoints(String[] wire) {
        List<Point> points = new ArrayList<>();

        Point p = new Point(0, 0);
        points.add(p);

        for (int i = 0; i < wire.length; i++) {
            char c = wire[i].charAt(0);
            int amount = Integer.parseInt(wire[i].substring(1));

            if (c == 'R') {
                for (int x = 1; x <= amount; x++) {
                    Point p2 = new Point(p.x + x, p.y);
                    points.add(p2);
                }
                p = points.get(points.size() - 1);
            } else if (c == 'L') {
                for (int x = 1; x <= amount; x++) {
                    Point p2 = new Point(p.x - x, p.y);
                    points.add(p2);
                }
                p = points.get(points.size() - 1);
            } else if (c == 'D') {
                for (int y = 1; y <= amount; y++) {
                    Point p2 = new Point(p.x, p.y - y);
                    points.add(p2);
                }
                p = points.get(points.size() - 1);
            } else if (c == 'U') {
                for (int y = 1; y <= amount; y++) {
                    Point p2 = new Point(p.x, p.y + y);
                    points.add(p2);
                }
                p = points.get(points.size() - 1);
            }

        }

        return points;
    }

    public List<Integer> calculateWireDistances(String[] wireOne, String[] wireTwo, List<Point> intersections) {
        List<Integer> distances = new ArrayList<>();

        for (Point p : intersections) {
            int distance = getLength(wireOne, p) + getLength(wireTwo, p);
            distances.add(distance);
        }

        return distances;
    }

    public int getLength(String[] wire, Point pp) {
        List<Point> points = new ArrayList<>();

        Point p = new Point(0, 0);
        points.add(p);

        int distance = 0;

        for (int i = 0; i < wire.length; i++) {
            char c = wire[i].charAt(0);
            int amount = Integer.parseInt(wire[i].substring(1));

            if (c == 'R') {
                for (int x = 1; x <= amount; x++) {
                    distance += 1;
                    Point p2 = new Point(p.x + x, p.y);
                    points.add(p2);

                    if (pp.x == p2.x && pp.y == p2.y) {
                        return distance;
                    }

                }
                p = points.get(points.size() - 1);
            } else if (c == 'L') {
                for (int x = 1; x <= amount; x++) {
                    distance += 1;
                    Point p2 = new Point(p.x - x, p.y);
                    points.add(p2);

                    if (pp.x == p2.x && pp.y == p2.y) {
                        return distance;
                    }

                }
                p = points.get(points.size() - 1);
            } else if (c == 'D') {
                for (int y = 1; y <= amount; y++) {
                    distance += 1;
                    Point p2 = new Point(p.x, p.y - y);
                    points.add(p2);

                    if (pp.x == p2.x && pp.y == p2.y) {
                        return distance;
                    }

                }
                p = points.get(points.size() - 1);
            } else if (c == 'U') {
                for (int y = 1; y <= amount; y++) {
                    distance += 1;
                    Point p2 = new Point(p.x, p.y + y);
                    points.add(p2);

                    if (pp.x == p2.x && pp.y == p2.y) {
                        return distance;
                    }

                }
                p = points.get(points.size() - 1);
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        DayThree problem = new DayThree();
        problem.run();
    }
}

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance() {
        return Math.abs(this.x) + Math.abs(this.y);
    }

    public String toString() {
        return this.x + " : " + this.y;
    }

    public int compareTo(Point p) {
        return this.getDistance() - p.getDistance();
    }
}

