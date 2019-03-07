package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import java.lang.Math;

public class Notes extends View {
    private double note;
    private int speed;
    private Resources resources;
    private int textColour;
    private Paint paint;
    private float lineHeight;
    private float lineWidth;
    private float margin;
    private Path notepath;
    private Canvas canvas;
    private Paint paintTail;
    //One Note head
    private static final float hd[][] =
            {
                    {8.0f, 0.0f},
                    {8.0f, 8.0f},
                    {-8.0f, 8.0f},
                    {-8.0f, 0.0f},
                    {-8.0f, -8.0f},
                    {8.0f, -8.0f},
                    {8.0f, 0.0f}
            };
    //the number of keys in one 八度
    private static final int OCTAVE = 12;
    //save one 8度's sharp & flat
    private static final String sharps[] =
            {
                    "",
                    "\u266F",
                    "\u266D",
                    "",
                    "",
                    "\u266F",
                    "",
                    "\u266D",
                    "",
                    "\u266D",
                    ""

            };

    // Scale offsets
    private static final int offset[] =
            {
                    0, 0, 1, 2, 2, 3,
                    3, 4, 5, 5, 6, 6
            };

    public Notes(Context context){
        super(context);
        resources = getResources();
        textColour = context.getResources().getColor(R.color.colorPrimary);
        paint = new Paint();
    }

    public Canvas createNote(float lineWidth, float lineHeight, int margin, double note, int speed, Canvas canvas, Paint paint) {
        this.note = note;
        this.canvas = canvas;
        this.paint = paint;

        // Note head
        notepath = new Path();
        notepath.moveTo(hd[0][0], hd[0][1]);

        for (int i = 1; i < hd.length; i += 3){
            notepath.cubicTo(hd[i][0], hd[i][1],
                    hd[i + 1][0], hd[i + 1][1],
                    hd[i + 2][0], hd[i + 2][1]);
            Log.v("heyhey",""+hd[i][0]+"," +hd[i][1]+",,"+
                    hd[i + 1][0]+","+ hd[i + 1][1]+",,"+
                    hd[i + 2][0]+","+ hd[i + 2][1]);
        }

        RectF bounds = new RectF();

        // Scale note head
        notepath.computeBounds(bounds, false);
        float scale = (lineHeight * 1.4f) / (bounds.top - bounds.bottom);
        Matrix matrix = new Matrix();
        matrix.setScale(-scale, scale);
        notepath.transform(matrix);

        paintTail = new Paint();

        paintTail.setStrokeWidth(4);
        paintTail.setColor(textColour);
        paintTail.setStyle(Paint.Style.FILL);
        paintTail.setTextSize(lineHeight * 4);
        paintTail.setTextAlign(Paint.Align.LEFT);

        // Calculate transform for note
        float xBase = lineWidth * 14;
        float yBase = lineHeight * 14;
        int intNote = (int)Math.floor(this.note);
        int index = (intNote + OCTAVE) % OCTAVE;
        int octave = intNote / OCTAVE;

        float dx = (octave * lineWidth * 3.5f) +
                (offset[index] * (lineWidth / 2));
        float dy = (octave * lineHeight * 3.5f) +
                (offset[index] * (lineHeight / 2));

        // Translate canvas
        canvas.translate(0, yBase - dy);

        //middle C's line
        if(note == 48){
            drawLeger();
        }


        // Draw note and accidental(sharp/flat)
        canvas.drawPath(notepath, paint);
        canvas.drawText(sharps[index], -lineWidth,
                lineHeight / 2, paint);

        if((note>=48&&note<60)||note<36)
            drawUptail();
        else
            drawDowntail();

        // Translate canvas
        canvas.translate(150, -(yBase - dy));

        return canvas;
    }

    protected void drawLeger(){
        canvas.drawLine(-60, 0,
                    60, 0, paint);
    }

    protected void drawUptail(){
        canvas.drawLine(32, 0,
                32, -145, paintTail);
    }

    protected void drawDowntail(){
        canvas.drawLine(-32, 0,
                -32, 145, paintTail);
    }

    // On draw
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }
}

