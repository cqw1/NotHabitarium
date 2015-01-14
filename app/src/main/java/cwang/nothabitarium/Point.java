package cwang.nothabitarium;

/**
 * Created by cwang on 1/13/2015.
 */
abstract class Point {

    private double x;
    private double y;

    public Point(double xInitial, double yInitial) {
        x = xInitial;
        y = yInitial;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
