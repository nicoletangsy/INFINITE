package comnicoletangsyinfinite.httpsgithub.infinite;

import android.graphics.RectF;

/**
 * Created by ssaurel on 15/03/2018.
 */
public class Key {

    public int key;
    public RectF rect;
    public boolean down;

    public Key(RectF rect, int key) {
        this.key = key;
        this.rect = rect;
    }
}