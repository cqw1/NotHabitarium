package cwang.nothabitarium;

/**
 * Created by cwang on 1/13/2015.
 */
public class CartesianPoint extends Point {
    public CartesianPoint(double xInitial, double yInitial) {
        super(xInitial, yInitial);
    }

    public IsometricPoint toIsometric() {
        double xIso = getX() - getY();
        double yIso = (getX() + getY()) / 2.0;
        return new IsometricPoint(xIso, yIso);
    }

    public CartesianPoint toCartesian() {
        return this;
    }
}
