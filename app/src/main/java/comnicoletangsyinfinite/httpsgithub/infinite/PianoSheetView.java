package comnicoletangsyinfinite.httpsgithub.infinite;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.content.res.TypedArray;

import java.util.ArrayList;

public class PianoSheetView extends View {

        private Paint paint;
        private Resources resources;
        private int textColour;
        private Rect clipRect;
        private RectF outlineRect;
        private int iwidth;
        private int iheight;
        private int width;
        private int height;

    //private double allNotes[][]={{48.5,4},{60,4}};
    private GeneratedMusicNotes allNotes = new GeneratedMusicNotes();
    private static final String TAG = "Staff";

    // Treble clef
    private static final float tc[][]=
            {
                    {-6, 16},
                    {-8, 13},
                    {-14, 19},
                    {-10, 35},
                    {2, 35},
                    {8, 37},
                    {21, 30},
                    {21, 17},
                    {21, 5},
                    {10, -1},
                    {0, -1},
                    {-12, -1},
                    {-24, 5},
                    {-26, 22},
                    {-25, 29},
                    {-25, 37},
                    {-7, 49},
                    {10, 61},
                    {10, 68},
                    {10, 73},
                    {10, 78},
                    {9, 82},
                    {7, 82},
                    {2, 78},
                    {-2, 68},
                    {-2, 62},
                    {-2, 25},
                    {10, 18},
                    {11, -8},
                    {11, -18},
                    {5, -23},
                    {-4, -23},
                    {-10, -23},
                    {-15, -18},
                    {-15, -13},
                    {-15, -8},
                    {-12, -4},
                    {-7, -4},
                    {3, -4},
                    {3, -20},
                    {-6, -17},
                    {-5, -23},
                    {9, -20},
                    {9, -9},
                    {7, 24},
                    {-5, 30},
                    {-5, 67},
                    {-5, 78},
                    {-2, 87},
                    {7, 91},
                    {13, 87},
                    {18, 80},
                    {17, 73},
                    {17, 62},
                    {10, 54},
                    {1, 45},
                    {-5, 38},
                    {-18, 33},
                    {-18, 19},
                    {-18, 7},
                    {-8, 1},
                    {0, 1},
                    {8, 1},
                    {15, 6},
                    {15, 14},
                    {15, 23},
                    {7, 26},
                    {2, 26},
                    {-5, 26},
                    {-9, 21},
                    {-6, 16}
            };

    // Bass clef
    private static final float xy = 2.5f;
    private static final float bc[][] =
            {
                    {-2.3f,3+xy},
                    {6,7+xy},
                    {10.5f,12+xy},
                    {10.5f,16+xy},
                    {10.5f,20.5f+xy},
                    {8.5f,23.5f+xy},
                    {6.2f,23.3f+xy},
                    {5.2f,23.5f+xy},
                    {2,23.5f+xy},
                    {0.5f,19.5f+xy},
                    {2,20+xy},
                    {4,19.5f+xy},
                    {4,18+xy},
                    {4,17+xy},
                    {3.5f,16+xy},
                    {2,16+xy},
                    {1,16+xy},
                    {0,16.9f+xy},
                    {0,18.5f+xy},
                    {0,21+xy},
                    {2.1f,24+xy},
                    {6,24+xy},
                    {10,24+xy},
                    {13.5f,21.5f+xy},
                    {13.5f,16.5f+xy},
                    {13.5f,11+xy},
                    {7,5.5f+xy},
                    {-2.0f,2.8f+xy},
                    {14.9f,21+xy},
                    {14.9f,22.5f+xy},
                    {16.9f,22.5f+xy},
                    {16.9f,21+xy},
                    {16.9f,19.5f+xy},
                    {14.9f,19.5f+xy},
                    {14.9f,21+xy},
                    {14.9f,15+xy},
                    {14.9f,16.5f+xy},
                    {16.9f,16.5f+xy},
                    {16.9f,15+xy},
                    {16.9f,13.5f+xy},
                    {14.9f,13.5f+xy},
                    {14.9f,15+xy}
            };
    private Path tclef;
    private Path bclef;

    private Matrix matrix;

    private float lineHeight;
    private float lineWidth;
    private int margin;

    // Constructor
    public PianoSheetView(Context context, AttributeSet attrs)
    {

        super(context, attrs);
        resources = getResources();
        textColour = context.getResources().getColor(R.color.colorPrimary);;

        paint = new Paint();
    }

    // On size changed
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // Save the new width and height
        iwidth = w;
        iheight = h;

        // Create some rects for
        // the outline and clipping
        outlineRect = new RectF(1, 1, iwidth - 1, iheight - 1);
        clipRect = new Rect(3, 3, iwidth - 3, iheight - 3);

        height = clipRect.bottom - clipRect.top;
        width = clipRect.right - clipRect.left;

        lineHeight = height / 14f;
        lineWidth = width / 16f;
        margin = width / 32;

        // Treble clef
        tclef = new Path();
        tclef.moveTo(tc[0][0], tc[0][1]);
        tclef.lineTo(tc[1][0], tc[1][1]);
        for (int i = 2; i < tc.length; i += 3) {
            tclef.cubicTo(tc[i][0], tc[i][1],
                    tc[i + 1][0], tc[i + 1][1],
                    tc[i + 2][0], tc[i + 2][1]);
        }

        // Bass clef
        bclef = new Path();
        bclef.moveTo(bc[0][0], bc[0][1]);
        for (int i = 1; i < 28; i += 3){
            bclef.cubicTo(bc[i][0], bc[i][1],
                    bc[i + 1][0], bc[i + 1][1],
                    bc[i + 2][0], bc[i + 2][1]);
        }

        bclef.moveTo(bc[28][0], bc[28][1]);
        for (int i = 29; i < 35; i += 3){
            bclef.cubicTo(bc[i][0], bc[i][1],
                    bc[i + 1][0], bc[i + 1][1],
                    bc[i + 2][0], bc[i + 2][1]);
        }

        bclef.moveTo(bc[35][0], bc[35][1]);
        for (int i = 36; i < bc.length; i += 3){
            bclef.cubicTo(bc[i][0], bc[i][1],
                    bc[i + 1][0], bc[i + 1][1],
                    bc[i + 2][0], bc[i + 2][1]);
        }
        RectF bounds = new RectF();

        // Scale treble clef
        tclef.computeBounds(bounds, false);
        float scale = (lineHeight*7) / (bounds.top - bounds.bottom);
        matrix = new Matrix();
        matrix.setScale(-scale, scale);
        matrix.postTranslate(margin + (lineHeight * 2), - lineHeight);
        tclef.transform(matrix);

        // Scale bass clef
        bclef.computeBounds(bounds, false);
        scale = (lineHeight * 3.5f) / (bounds.top - bounds.bottom);
        matrix.reset();
        matrix.setScale(-scale, scale);
        matrix.postTranslate(margin + lineHeight, lineHeight * 5.4f);
        bclef.transform(matrix);
    }

    // On draw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Set up paint
        paint.setStrokeWidth(2);
        paint.setColor(textColour);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(lineHeight * 4);
        paint.setTextAlign(Paint.Align.LEFT);

        // Draw staff
        canvas.translate(0, height / 2f);
        for (int i = 1; i < 6; i++) {
            canvas.drawLine(margin, i * lineHeight,
                    width - margin, i * lineHeight, paint);
            canvas.drawLine(margin, i * -lineHeight,
                    width - margin, i * -lineHeight, paint);
        }

        // Draw treble and bass clef
        canvas.drawPath(tclef, paint);
        canvas.drawPath(bclef, paint);

        // Translate canvas from C4 position
        canvas.translate(400, 0);

        ArrayList<Notes> notesArrayList = new ArrayList<>();
        for (int i = 0; i <allNotes.getTotal(); i++) {
            notesArrayList.add(new Notes(this.getContext()));
            canvas = notesArrayList.get(i).createNote(lineWidth, lineHeight, margin, allNotes.getNote(i).getNote(), 4, canvas, paint);
        }
        float translationX = notesArrayList.get(0).getTranslationX();
        Log.v("translationx",""+translationX);
        ObjectAnimator valueAnimator = ObjectAnimator.ofFloat(notesArrayList.get(0), "translationX", 200);
        Log.v("did you have something",""+valueAnimator.toString());
        valueAnimator.setDuration(2000);
        valueAnimator.start();
        translationX = notesArrayList.get(0).getTranslationX();
        Log.v("translationx",""+translationX);
    }
}
