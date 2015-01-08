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
        int radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawCircle(x/2, y/2, radius, paint);

        Bitmap tiles = BitmapFactory.decodeResource(getResources(), R.drawable.tiles);

        for (int r = 4; r < 6; r++) {
            for (int c = 4; c < 6; c++) {
                int tempX = r * tiles.getWidth()/4;
                int tempY = c * tiles.getHeight()/4;
                placeTile(tiles, twoDimToIso(new Point(tempX, tempY)), canvas);
            }
        }
    }

    protected Point twoDimToIso(Point p) {
        double xIso = p.getX() - p.getY();
        double yIso = (p.getX() + p.getY()) / 2.0;
        return new Point(xIso, yIso);
    }

    protected void placeTile(Bitmap bitmap, Point p, Canvas canvas) {
        Rect sourceBounds = new Rect(0, bitmap.getHeight()*3/4, bitmap.getWidth()/4, bitmap.getHeight());
        Rect destinationBounds = new Rect(((int)p.getX() + (bitmap.getWidth()/4 * 2))/2,(int)p.getY()/2, ((int)p.getX() + (bitmap.getWidth()/4 * 2))/2 + bitmap.getWidth()/4, (int)p.getY()/2 + bitmap.getHeight()/4);
        canvas.drawBitmap(bitmap, sourceBounds, destinationBounds, null);
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
