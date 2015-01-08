package cwang.nothabitarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by cwang on 1/6/2015.
 */
public class BackgroundView extends View{
    public BackgroundView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int x = getWidth();
        int y = getHeight();

        Bitmap tiles = BitmapFactory.decodeResource(getResources(), R.drawable.grasstile);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int tempX = r * tiles.getWidth();
                int tempY = c * tiles.getHeight();
                placeTile(tiles, twoDimToIso(new Point(tempX, tempY)), canvas);
            }
        }
    }

    protected void placeTile(Bitmap bitmap, Point p, Canvas canvas) {
        Rect sourceBounds = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect destinationBounds = new Rect(((int)p.getX()/2 + (getWidth()/2)), (int)p.getY()/2 + getHeight()/2, ((int)p.getX()/2 + (getWidth()/2)) + bitmap.getWidth(), (int)p.getY()/2 + getHeight()/2 + bitmap.getHeight());
        canvas.drawBitmap(bitmap, sourceBounds, destinationBounds, null);
    }

    protected Point twoDimToIso(Point p) {
        double xIso = p.getX() - p.getY();
        double yIso = (p.getX() + p.getY()) / 2.0;
        return new Point(xIso, yIso);
    }
}

class Point {
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
