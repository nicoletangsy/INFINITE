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
import java.util.ArrayList;

//Notes View
public class Notes extends View {

    private Resources resources;
    private Canvas canvas;
    private Path notepath;

    private Paint paint;
    private Paint thePaint;//for fit in require paint
    private Paint paint23;//paint of note type 2,3
    private Paint paintwrong;
    private Paint paint23wrong;
    private Paint paintcorrect;
    private Paint paint23correct;
    private Paint paintTail;
    private Paint sharpPiant;
    private Paint flatPiant;
    private Paint paint1;

    private int textColour;
    private int wrongColour;
    private int correctColour;
    private double hand;
    private double note;
    private double note1;
    private double note2;


    private float lineHeight;
    private float lineWidth;
    private float dy;
    private float dx;
    private float yBase;
    private float xBase;

    private static final int noteDiff[] =
            {
                    0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6
            };

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

    public Notes(Context context) {

        super(context);
        resources = getResources();
        textColour = context.getResources().getColor(R.color.black);
        wrongColour = context.getResources().getColor(R.color.red);

        correctColour = context.getResources().getColor(R.color.green);

        paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(textColour);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(lineHeight * 4);
        paint.setTextAlign(Paint.Align.LEFT);

        paint23 = new Paint();
        paint23.setStrokeWidth(4);
        paint23.setColor(textColour);
        paint23.setStyle(Paint.Style.STROKE);
        paint23.setTextSize(lineHeight * 4);
        paint23.setTextAlign(Paint.Align.LEFT);

        paintwrong = new Paint();
        paintwrong.setStrokeWidth(4);
        paintwrong.setColor(wrongColour);
        paintwrong.setStyle(Paint.Style.FILL);
        paintwrong.setTextSize(lineHeight * 4);
        paintwrong.setTextAlign(Paint.Align.LEFT);

        paint23wrong = new Paint();
        paint23wrong = new Paint();
        paint23wrong.setStrokeWidth(4);
        paint23wrong.setColor(wrongColour);
        paint23wrong.setStyle(Paint.Style.STROKE);
        paint23wrong.setTextSize(lineHeight * 4);
        paint23wrong.setTextAlign(Paint.Align.LEFT);

        paintcorrect = new Paint();
        paintcorrect.setStrokeWidth(4);
        paintcorrect.setColor(correctColour);
        paintcorrect.setStyle(Paint.Style.FILL);
        paintcorrect.setTextSize(lineHeight * 4);
        paintcorrect.setTextAlign(Paint.Align.LEFT);

        paint23correct = new Paint();
        paint23correct = new Paint();
        paint23correct.setStrokeWidth(4);
        paint23correct.setColor(correctColour);
        paint23correct.setStyle(Paint.Style.STROKE);
        paint23correct.setTextSize(lineHeight * 4);
        paint23correct.setTextAlign(Paint.Align.LEFT);

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

    public Canvas create1Note(float lineWidth, float lineHeight, ArrayList<Double> note, double hand, Canvas canvas) {

        this.note = note.get(0);
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;
        if (note.size() == 3) {
            scaleNoteDrawFlat(1, 0, -1, hand);
        } else
            scaleNoteDrawFlat(1, 0, note.get(3), hand);


        return canvas;
    }

    public Canvas translate1Note(Canvas canvas, float noteWidth) {
        canvas.translate(noteWidth * 4, -(yBase - dy));
        return canvas;
    }

    public Canvas create2Note(float lineWidth, float lineHeight, float noteWidth, ArrayList<Double> note, double hand, Canvas canvas) {
        this.note = note.get(0);
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;

        if (note.size() == 3) {
            scaleNoteDrawFlat(2, 3.5f, -1, hand);
        } else
            scaleNoteDrawFlat(2, 3.5f, note.get(3), hand);

        // Translate canvas
        canvas.translate(noteWidth * 2, -(yBase - dy));

        return canvas;

    }

    public Canvas create3Note(float lineWidth, float lineHeight, float noteWidth, ArrayList<Double> note, double hand, Canvas canvas) {
        this.note = note.get(0);
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;

        if (note.size() == 3) {
            scaleNoteDrawFlat(3, 3.5f, -1, hand);
        } else
            scaleNoteDrawFlat(3, 3.5f, note.get(3), hand);

        // Translate canvas
        canvas.translate(noteWidth * 3, -(yBase - dy));

        return canvas;
    }

    public float dot3note(float lineWidth, float lineHeight, double note) {
        int intNote = (int) Math.ceil(note);
        int index = (intNote + OCTAVE) % OCTAVE;
        int octave = intNote / OCTAVE;
        yBase = lineHeight * 14;
        if (hand == 0) {
            dy = +(octave * lineHeight * 3.5f) + (offset[index] * (lineHeight / 2));
        } else {
            dy = (octave * lineHeight * 3.5f) + (offset[index] * (lineHeight / 2));
        }
        return yBase - dy;
    }

    public Canvas create4Note(float lineWidth, float lineHeight, float noteWidth, ArrayList<Double> note, double hand, Canvas canvas) {
        this.note = note.get(0);
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;

        if (note.size() == 3) {
            scaleNoteDrawFlat(4, 3.5f, -1, hand);
        } else
            scaleNoteDrawFlat(4, 3.5f, note.get(3), hand);


        Log.v("noteWidth2", noteWidth + "," + dy);
        // Translate canvas
        canvas.translate(noteWidth, -(yBase - dy));

        return canvas;
    }


    public Canvas create8Note(float lineWidth, float lineHeight, float noteWidth, ArrayList<Double> note1, ArrayList<Double> note2, double hand, Canvas canvas) {
        this.note1 = note1.get(0);
        this.note2 = note2.get(0);
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;
        float min;
        float max;
        float theLine;

        float tailHeight1 = 3.5f;
        float tailHeight2 = 3.5f;

        boolean upper = tailIsUpper(8);

        Log.v("upper???", "" + upper);

        if (note1.get(0) > note2.get(0) || note1 == note2) {
            max = note1.get(0).floatValue();
            min = note2.get(0).floatValue();
        } else {
            min = note1.get(0).floatValue();
            max = note2.get(0).floatValue();
        }

        float noteDiff = noteDiff(min, max);
        noteDiff = noteDiff / 2;

        if (noteDiff < 1) {
            theLine = noteDiff;
        } else if (noteDiff < 2.5) {
            theLine = 1;
            if (max == note1.get(0)) {
                if (upper)
                    tailHeight1 = tailHeight1 - (noteDiff - 1);
                else
                    tailHeight2 = tailHeight2 - (noteDiff - 1);
            } else {
                if (upper)
                    tailHeight2 = tailHeight2 - (noteDiff - 1);
                else
                    tailHeight1 = tailHeight1 - (noteDiff - 1);
            }
        } else {
            theLine = 1;
            if (max == note1.get(0)) {
                if (upper) {
                    tailHeight2 = tailHeight2 + (noteDiff - 2);
                    tailHeight1 = 2;
                } else {
                    tailHeight1 = tailHeight1 + (noteDiff - 2);
                    tailHeight2 = 2;
                }
            } else {
                if (upper) {
                    tailHeight1 = tailHeight1 + (noteDiff - 2);
                    tailHeight2 = 2;
                } else {
                    tailHeight2 = tailHeight2 + (noteDiff - 2);
                    tailHeight1 = 2;
                }
            }
        }

        this.note = note1.get(0);
        if (note1.size() == 3) {
            scaleNoteDrawFlat(8, tailHeight1, -1, hand);
        } else
            scaleNoteDrawFlat(8, tailHeight1, note1.get(3), hand);

        if (note1.size() < 4) {
            thePaint = paint;
        } else if (note1.get(3) == 1) {
            thePaint = paintwrong;
        }
        if (note1.size() < 4 || note1.get(3) == 1) {
            for (int i = 0; i < 13; i = i + 4) {
                if (max == note2.get(0)) {
                    if (upper)
                        canvas.drawLine(lineHeight / 1.8f, -((lineHeight * tailHeight1) + i),
                                noteWidth / 2 + lineHeight / 1.5f, -((lineHeight * (tailHeight1 + theLine)) + i), thePaint);
                    else
                        canvas.drawLine((lineHeight / 1.8f) - lineHeight * 1.2f, (lineHeight * tailHeight1) - i,
                                noteWidth / 2 + lineHeight / 1.5f - lineHeight * 1.2f, (lineHeight * (tailHeight1 - theLine)) - i, thePaint);
                } else {
                    if (upper)
                        canvas.drawLine(lineHeight / 1.8f, (-lineHeight * tailHeight1) - i,
                                noteWidth / 2 + lineHeight / 1.5f, (-lineHeight * (tailHeight1 - theLine)) - i, thePaint);
                    else
                        canvas.drawLine((lineHeight / 1.8f) - lineHeight * 1.2f, (lineHeight * tailHeight1) - i,
                                noteWidth / 2 + lineHeight / 1.5f - lineHeight * 1.2f, (lineHeight * (tailHeight1 + theLine)) - i, thePaint);
                }
            }
        }
        // Translate canvas
        canvas.translate(noteWidth / 2, -(yBase - dy));

        this.note = note2.get(0);
        if (note2.size() == 3) {
            scaleNoteDrawFlat(8, tailHeight2, -1, hand);
        } else
            scaleNoteDrawFlat(8, tailHeight2, note2.get(3), hand);


        // Translate canvas
        canvas.translate(noteWidth / 2, -(yBase - dy));

        return canvas;
    }

    //scale note head and draw flat sharp
    public void scaleNoteDrawFlat(int noteType, float tailHeight, double wrong, double hand) {

        drawNoteHead(noteType);

        RectF bounds = new RectF();
        // Scale note head
        notepath.computeBounds(bounds, false);
        float scale = (lineHeight * 1.4f) / (bounds.top - bounds.bottom);

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale * 0.78f);
        matrix.postRotate(-33.75f);

        notepath.transform(matrix);

        // Calculate transform for note
        xBase = lineWidth * 14;
        if (hand == 0) {
            yBase = lineHeight * 8;
        } else
            yBase = lineHeight * 14;
        int intNote = (int) Math.ceil(this.note);
        int index = (intNote + OCTAVE) % OCTAVE;
        int octave = intNote / OCTAVE;

        dx = (octave * lineWidth * 3.5f) + (offset[index] * (lineWidth / 2));
        dy = (octave * lineHeight * 3.5f) + (offset[index] * (lineHeight / 2));

        // Translate canvas y position
        canvas.translate(0, yBase - dy);

        //middle C's line
        if (note <= 49 && note > 47) {
            drawLeger(noteType, note, wrong);
        }

        if (noteType > 1) {
            if (noteType > 3) {
                if (wrong == 1)
                    thePaint = paintwrong;
                else if (wrong == 0)
                    thePaint = paintcorrect;
                else
                    thePaint = paint;
            } else if (noteType == 2 || noteType == 3) {
                if (wrong == 1)
                    thePaint = paint23wrong;
                else if (wrong == 0)
                    thePaint = paint23correct;
                else
                    thePaint = paint23;

            } else {
                if (wrong == 1)
                    thePaint = paintwrong;
                else if (wrong == 0)
                    thePaint = paintcorrect;
                else
                    thePaint = paint;

            }

            canvas.drawPath(notepath, thePaint);
        }
        //////////////////////////
        //Draw accidental(sharp)//
        //dont know why not work//
        //////////////////////////
        if (note % OCTAVE == 1 || note % OCTAVE == 3 || note % OCTAVE == 6 || note % OCTAVE == 8 || note % OCTAVE == 10) {
            canvas.drawText(sharps[0], -lineHeight, 0, paint);
        }
        //Draw accidental(flat)
        else if ((note - Math.floor(note)) == 0.5) {
            canvas.drawText(sharps[1], -lineHeight, 0, paint);
        }

        if (tailHeight > 0)
            drawTail(tailHeight, noteType, wrong);

    }

    //Calculate note difference
    public float noteDiff(float min, float max) {
        int minN = (int) Math.ceil(min);
        int maxN = (int) Math.ceil(max);
        int notedimax = noteDiff[maxN % 12];
        int notedimin = noteDiff[minN % 12];
        int maxFloor = (maxN / 12) * 7;
        int minFloor = (minN / 12) * 7;
        return notedimax + maxFloor - notedimin - minFloor;
    }

    //draw a note tail
    public void drawTail(float tailHeight, int noteType, double wrong) {
        if (noteType > 3) {

            if (wrong == 1) {
                thePaint = paintwrong;
            } else if (wrong == -1) {
                thePaint = paint;
            }


            if (wrong == 1 || wrong == -1) {

                if (tailIsUpper(noteType))
                    canvas.drawLine(lineHeight / 1.7f, -lineHeight / 4,
                            lineHeight / 1.7f, -lineHeight * tailHeight, thePaint);
                else
                    canvas.drawLine(-lineHeight / 1.7f, lineHeight / 4,
                            -lineHeight / 1.7f, lineHeight * tailHeight, thePaint);
            }
        } else if (noteType <= 3 && wrong == -1) {

            if (wrong == 1) {
                thePaint = paintwrong;
            } else if (wrong == -1) {
                thePaint = paint;
            }
            if (wrong == 1 || wrong == -1) {
                if (tailIsUpper(noteType))
                    canvas.drawLine(lineHeight / 1.6f, -lineHeight / 4,
                            lineHeight / 1.6f, -lineHeight * tailHeight, thePaint);
                else
                    canvas.drawLine(-lineHeight / 1.6f, lineHeight / 4,
                            -lineHeight / 1.6f, lineHeight * tailHeight, thePaint);
            }
        }
    }

    //whether tail is upper
    public boolean tailIsUpper(int noteType) {
        boolean upper = true;

        if (noteType > 4) {
            if (noteType == 8) {
                if (hand == 0) {
                    upper = false;
                    if (note1 <= 36 && note2 <= 36) {
                        upper = true;
                    }
                } else if (note1 > 58 && note2 > 58) {
                    upper = false;
                }

            }
        } else {
            if (hand == 0) {
                if (note > 36)
                    upper = false;
            } else {
                if (note >= 59) {
                    upper = false;
                }
            }

        }


        return upper;
    }


    //draw note head
    public void drawNoteHead(int noteType) {

        // Note head
        notepath = new Path();


        notepath.moveTo(hd[0][0], hd[0][1]);

        if (noteType > 1) {
            for (int i = 1; i < hd.length; i += 3) {
                notepath.cubicTo(hd[i][0], hd[i][1],
                        hd[i + 1][0], hd[i + 1][1],
                        hd[i + 2][0], hd[i + 2][1]);
            }
        }

    }


    //Stroke for a bar
    public Canvas createStroke(float lineWidth, float lineHeight, float noteWidth, Canvas canvas) {

        this.canvas = canvas;

        canvas.translate(-noteWidth / 5, 0);
        canvas.drawLine(0, -lineHeight, 0, -lineHeight - (lineHeight * 4), paint);
        canvas.translate(noteWidth / 5, 0);

        return canvas;
    }

    //for C only
    //miss left hand
    protected void drawLeger(int noteType, double note, double wrong) {
        if (wrong == 1) {
            thePaint = paintwrong;
        } else if (wrong == 0) {
            thePaint = paintcorrect;
        } else {
            if (noteType > 1)
                thePaint = paint;
        }
        if (noteType > 1)
            canvas.drawLine(-lineHeight, 0, lineHeight, 0, thePaint);
        else
            canvas.drawLine(-lineHeight * 1.5f, 0, lineHeight * 1.5f, 0, thePaint);

    }

    // On draw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

