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
    private Paint sharpPiant;
    private Paint flatPiant;
    private Paint paint1;
    private float dy;
    private float dx;
    private float yBase;
    private float xBase;

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
                    "\u266F",
                    "\u266D"
            };

    // Scale offsets (Changed)
    private static final int offset[] =
            {
                    0, 0, 1, 1, 2, 3,
                    3, 4, 4, 5, 5, 6
            };

    public Notes(Context context){

        super(context);
        resources = getResources();
        textColour = context.getResources().getColor(R.color.black);
        paint = new Paint();

        paint.setStrokeWidth(4);
        paint.setColor(textColour);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(lineHeight * 4);
        paint.setTextAlign(Paint.Align.LEFT);

        paintTail = new Paint();
        paintTail.setStrokeWidth(20);
        paintTail.setColor(textColour);
        paintTail.setStyle(Paint.Style.FILL);
        paintTail.setTextSize(lineHeight * 4);
        paintTail.setTextAlign(Paint.Align.LEFT);

        sharpPiant = new Paint();
        sharpPiant.setStrokeWidth(1);
        sharpPiant.setColor(textColour);
        sharpPiant.setStyle(Paint.Style.FILL);
        sharpPiant.setTextSize(lineHeight * 2);
        sharpPiant.setTextAlign(Paint.Align.LEFT);

        flatPiant = new Paint();
        flatPiant.setStrokeWidth(1);
        flatPiant.setColor(textColour);
        flatPiant.setStyle(Paint.Style.FILL);
        flatPiant.setTextSize(lineHeight * 3.5f);
        flatPiant.setTextAlign(Paint.Align.LEFT);

        paint1 = new Paint();
        paint1.setStrokeWidth(1);
        paint1.setColor(textColour);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setTextSize(lineHeight * 4);
        paint1.setTextAlign(Paint.Align.LEFT);

    }

    public Canvas create1Note(float lineWidth, float lineHeight, int margin, double note, Canvas canvas) {
        this.note = note;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;
        this.margin = margin;


        scaleNoteDrawFlat(1,0);

        // Translate canvas
        canvas.translate(300, -(yBase - dy));

        return canvas;}

    public Canvas create2Note(float lineWidth, float lineHeight, int margin, double note, Canvas canvas) {return canvas;}

    public Canvas create3Note(float lineWidth, float lineHeight, int margin, double note, Canvas canvas) {return canvas;}

    public Canvas create4Note(float lineWidth, float lineHeight, int margin, double note, Canvas canvas) {

        this.note = note;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;
        this.margin = margin;


        scaleNoteDrawFlat(4,3.5f);

        // Translate canvas
        canvas.translate(156, -(yBase - dy));

        return canvas;
    }

    public Canvas create8Note(float lineWidth, float lineHeight, int margin, double note1,double note2, Canvas canvas) {

        this.note = note1;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;
        this.margin = margin;

        float tailHeight1 = 0;
        float tailHeight2 = 0;
        float noteDiff = 0;

        if(note1-note2==-8){
            tailHeight1 = 3;
            tailHeight2 = 2;
            noteDiff = 1f;
        }
        if(note1-note2==-6){
            tailHeight1 = 3;
            tailHeight2 = 2.5f;
            noteDiff = 1f;
        }
        if(note1-note2==-4){
            tailHeight1 = 3 ;
            tailHeight2 = 3f;
            noteDiff = 1f;
        }
        if(note1-note2==-2){
            tailHeight1 = 3;
            tailHeight2 = 3f;
            noteDiff = 0.5f;
        }
        if(note1-note2==0){
            tailHeight1 = 3f;
            tailHeight2 = 3f;
            noteDiff = 0.0f;
        }
        if(note1-note2==2){
            tailHeight1 = 3f;
            tailHeight2 = 3;
            noteDiff = -0.5f;
        }
        if(note1-note2==4){
            tailHeight1 = 3f ;
            tailHeight2 = 3;
            noteDiff = -1f;
        }
        if(note1-note2==6){
            tailHeight1 = 3f;
            tailHeight2 = 3;
            noteDiff = -1f;
        }
        if(note1-note2==8){
            tailHeight1 = 2;
            tailHeight2 = 3;
            noteDiff = -1f;
        }

        scaleNoteDrawFlat(8,tailHeight1);

        canvas.drawLine(lineHeight/1.5f-1, -lineHeight*tailHeight1,
                100+(lineHeight/1.5f)+1, -lineHeight*(tailHeight1+noteDiff), paintTail);

        // Translate canvas
        canvas.translate(100, -(yBase - dy));

        this.note = note2;
        scaleNoteDrawFlat(8,tailHeight2);


        // Translate canvas
        canvas.translate(100, -(yBase - dy));

        return canvas;
    }

    public Canvas create16Note(float lineWidth, float lineHeight, int margin, double note1,double note2, double note3, double note4,Canvas canvas) {return canvas;}




    //Stroke for a bar
    public Canvas createStroke(float lineWidth, float lineHeight, int margin, Canvas canvas){

        this.canvas = canvas;

        canvas.translate(-40, 0);
        canvas.drawLine(0,-lineHeight,0,-lineHeight-(lineHeight*4),paint);

        // Translate canvas
        canvas.translate(110, 0);

        return canvas;
    }

    protected void drawLeger(){
        canvas.drawLine(-lineHeight, 0, lineHeight, 0, paint);
    }




    //scale note head and draw flat sharp
    public void scaleNoteDrawFlat(int noteType,float tailHeight){


        drawNoteHead(noteType);

        RectF bounds = new RectF();
        // Scale note head
        notepath.computeBounds(bounds, false);
        float scale = (lineHeight * 1.4f) / (bounds.top - bounds.bottom);
        Matrix matrix = new Matrix();
        matrix.setScale(-scale, scale);
        notepath.transform(matrix);


        // Calculate transform for note
        xBase = lineWidth * 14;
        yBase = lineHeight * 14;
        int intNote = (int)Math.ceil(this.note);
        int index = (intNote + OCTAVE) % OCTAVE;
        int octave = intNote / OCTAVE;

        dx = (octave * lineWidth * 3.5f) + (offset[index] * (lineWidth / 2));
        dy = (octave * lineHeight * 3.5f) + (offset[index] * (lineHeight / 2));

        // Translate canvas y position
        canvas.translate(0, yBase - dy);

        //middle C's line
        if(note == 48){
            drawLeger();
        }

        // Draw note
        if(noteType<3)
            canvas.drawText("\uD834\uDD5D",0,-100, paint1);
        else
            canvas.drawPath(notepath, paint);

        //////////////////////////
        //Draw accidental(sharp)//
        //dont know why not work//
        //////////////////////////
        if(note % OCTAVE == 1||note % OCTAVE ==3||note % OCTAVE ==6||note % OCTAVE ==8||note % OCTAVE ==10) {
            canvas.drawText(sharps[0], -lineHeight, 0, paint);
        }
        //Draw accidental(flat)
        else if ((note - Math.floor(note)) == 0.5) {
            canvas.drawText(sharps[1], -lineHeight, 0, paint);
        }

        if(tailHeight>0)
        drawTail(tailHeight);

    }


    //draw a note tail
    public void drawTail(float tailHeight){
        //Draw tail
        if((note >= 48 && note < 60)||note < 36)
            canvas.drawLine(lineHeight/1.5f, 0,
                    lineHeight/1.5f, -lineHeight*tailHeight, paint);
        else
            canvas.drawLine(-lineHeight/1.5f, 0,
                    -lineHeight/1.5f, lineHeight*tailHeight, paint);

    }

    //draw note head
    public void drawNoteHead(int noteType){

        // Note head
        notepath = new Path();


        notepath.moveTo(hd[0][0], hd[0][1]);

        if(noteType == 4||noteType == 8||noteType == 16||noteType == 32) {
            for (int i = 1; i < hd.length; i += 3) {
                notepath.cubicTo(hd[i][0], hd[i][1],
                        hd[i + 1][0], hd[i + 1][1],
                        hd[i + 2][0], hd[i + 2][1]);
            }
        }

    }
    // On draw
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }
}

