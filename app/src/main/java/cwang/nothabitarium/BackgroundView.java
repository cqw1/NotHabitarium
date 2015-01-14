package cwang.nothabitarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import java.util.List;

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

        Bitmap grasstile = BitmapFactory.decodeResource(getResources(), R.drawable.grasstile);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int tempX = r * grasstile.getWidth();
                int tempY = c * grasstile.getHeight();
                placeTile(grasstile, (new CartesianPoint(tempX, tempY)).toIsometric(), canvas);
            }
        }
    }

    protected void placeTile(Bitmap bitmap, Point p, Canvas canvas) {
        Rect sourceBounds = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect destinationBounds = new Rect(((int)p.getX()/2 + (getWidth()/2)), (int)p.getY()/2 + getHeight()/2, ((int)p.getX()/2 + (getWidth()/2)) + bitmap.getWidth(), (int)p.getY()/2 + getHeight()/2 + bitmap.getHeight());
        canvas.drawBitmap(bitmap, sourceBounds, destinationBounds, null);
    }
}


