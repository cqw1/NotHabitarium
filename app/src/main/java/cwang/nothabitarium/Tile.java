package cwang.nothabitarium;

import android.graphics.Bitmap;

/**
 * Created by cwang on 1/13/2015.
 */
public class Tile {
    private Bitmap bitmap;
    private Point upperLeft;

    public Tile(Bitmap bitmapInput, Point upperLeftInput) {
        bitmap = bitmapInput;
        upperLeft = upperLeftInput;
    }



}
