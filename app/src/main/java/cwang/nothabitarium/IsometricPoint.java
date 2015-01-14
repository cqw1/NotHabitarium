package cwang.nothabitarium;

/**
 * Created by cwang on 1/13/2015.
 */
public class IsometricPoint extends Point{
    public IsometricPoint(double xInitial, double yInitial) {
        super(xInitial, yInitial);
    }

    public IsometricPoint toIsometric() {
        return this;
    }

    public CartesianPoint toCartesian() {
        double xCart = (2 * getY() + getX()) / 2.0;
        double yCart = (2 * getY() - getX()) / 2.0;
        return new CartesianPoint(xCart, yCart);
    }
}
