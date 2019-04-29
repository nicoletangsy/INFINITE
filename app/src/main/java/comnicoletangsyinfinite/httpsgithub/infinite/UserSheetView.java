package comnicoletangsyinfinite.httpsgithub.infinite;

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
import android.view.animation.TranslateAnimation;

import java.util.ArrayList;

import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_Music_Sheet_Type;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_GENERATED_MUSIC_NOTES;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandPractice.A_COMPARE_MUSIC_SHEET;
import static comnicoletangsyinfinite.httpsgithub.infinite.PianoSheetView.FIRST_NOTE;

public class UserSheetView extends View {

    private Paint paint;
    private Paint painttt;

    private Rect clipRect;

    private int textColour;
    private int margin;
    private int iwidth;
    private int iheight;
    private int width;
    private int height;

    private int leftHand = 0;

    private float lineHeight;
    private float lineWidth;

    //[0][0]:bpm ; [0][1]:beat ; [1][0]:flat(0)/sharp(1) ; [1][1]:key(0-7) ;[2][0]:left hand(0)/right hand(1)
    private ArrayList<ArrayList<Double>> theSheet = new ArrayList<>();

    // Constructor
    public UserSheetView(Context context, AttributeSet attrs) {

        super(context, attrs);
        textColour = context.getResources().getColor(R.color.black);

        paint = new Paint();
        painttt = new Paint();
    }

    // On size changed
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // Save the new width and height
        iwidth = w;
        iheight = h;
        clipRect = new Rect(3, 3, iwidth - 3, iheight - 3);

        height = clipRect.bottom - clipRect.top;
        width = clipRect.right - clipRect.left;

        lineHeight = height / 36;
        lineWidth = width / 19f;
        margin = width / 38;

    }

    // On draw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        theSheet = A_COMPARE_MUSIC_SHEET.getSheet();



        Log.v("kakakakakakacom",""+theSheet);

        if (theSheet.get(2).get(0) == 0) {
            leftHand = 1;
        }

        // Set up paint
        paint.setStrokeWidth(2);
        paint.setColor(textColour);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(lineHeight * 4);
        paint.setTextAlign(Paint.Align.LEFT);


        painttt.setStrokeWidth(1);
        painttt.setColor(textColour);
        painttt.setStyle(Paint.Style.FILL);
        painttt.setTextSize(lineHeight * 2.5f);
        painttt.setTextAlign(Paint.Align.LEFT);

        canvas.translate(0, height / 4.5f);
        canvas.translate(0, (height / 4) * 3);
        canvas.translate(lineWidth * 1.3f, -height / 1.33f);
        canvas.translate((float) (theSheet.get(1).get(1) * 28), 0);
        canvas.translate(100, 0);

        float noteArea = ((width * 37 / 38) - ((float) FIRST_NOTE.getX()));
        float noteWidth = noteArea / (float) (theSheet.get(0).get(1) * 2);

        int j = 0;
        float totalBeat = 0;
        ArrayList<Notes> notesArrayList = new ArrayList<>();

        for (int i = 3; i < theSheet.size(); i++) {

            //whether the note is 1 note
            if (theSheet.get(i).get(1) == 1) {
                notesArrayList.add(new Notes(this.getContext()));
                canvas = notesArrayList.get(j).create1Note(lineWidth, lineHeight, theSheet.get(i), theSheet.get(2).get(0), canvas);
                canvas.drawText("\uD834\uDD5D", -lineHeight, lineHeight / 2, paint);
                canvas = notesArrayList.get(j).translate1Note(canvas, noteWidth);
                totalBeat = totalBeat + 4;
            }

            //whether the note is 2 note
            else if (theSheet.get(i).get(1) == 2) {
                notesArrayList.add(new Notes(this.getContext()));
                canvas = notesArrayList.get(j).create2Note(lineWidth, lineHeight, noteWidth, theSheet.get(i), theSheet.get(2).get(0), canvas);
                totalBeat = totalBeat + 2;
            }

            //whether the note is 3 note
            else if (theSheet.get(i).get(1) == 3) {
                notesArrayList.add(new Notes(this.getContext()));
                canvas = notesArrayList.get(j).create3Note(lineWidth, lineHeight, noteWidth, theSheet.get(i), theSheet.get(2).get(0), canvas);
                float pos = notesArrayList.get(j).dot3note(lineWidth, lineHeight, theSheet.get(i).get(0));
                canvas.drawText(".", -noteWidth * 2.85f, pos + lineHeight * 0.3f, painttt);
                totalBeat = totalBeat + 3;
            }

            //whether the note is 4 note
            else if (theSheet.get(i).get(1) == 4) {
                notesArrayList.add(new Notes(this.getContext()));
                canvas = notesArrayList.get(j).create4Note(lineWidth, lineHeight, noteWidth, theSheet.get(i), theSheet.get(2).get(0), canvas);
                totalBeat++;
            }

            //whether the note is 8note
            else if (theSheet.get(i).get(1) == 8) {
                    notesArrayList.add(new Notes(this.getContext()));
                    canvas = notesArrayList.get(j).create8Note(lineWidth, lineHeight, noteWidth, theSheet.get(i), theSheet.get(i + 1), theSheet.get(2).get(0), canvas);
                    i++;
                    totalBeat++;
            }

            //To next line
            if (totalBeat % 8 == 0) {
                canvas.translate(-noteArea, height / 3.975f);
            }

            j++;
        }
    }

}
