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

public class Notes extends View {

    private Resources resources;
    private Canvas canvas;
    private Path notepath;

    private Paint paint;
    private Paint paint423;
    private Paint paintTail;
    private Paint sharpPiant;
    private Paint flatPiant;
    private Paint paint1;

    private int speed;
    private int textColour;
    private double hand;
    private double note;
    private double note1;
    private double note2;
    private double note3;
    private double note4;


    private float lineHeight;
    private float lineWidth;
    //the width of a 4th note
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
        paint = new Paint();

        paint.setStrokeWidth(4);
        paint.setColor(textColour);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(lineHeight * 4);
        paint.setTextAlign(Paint.Align.LEFT);

        paint423 = new Paint();
        paint423.setStrokeWidth(4);
        paint423.setColor(textColour);
        paint423.setStyle(Paint.Style.STROKE);
        paint423.setTextSize(lineHeight * 4);
        paint423.setTextAlign(Paint.Align.LEFT);

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

    public Canvas create1Note(float lineWidth, float lineHeight, double note, double hand, Canvas canvas) {

        this.note = note;
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;

        scaleNoteDrawFlat(1, 0, hand);

        return canvas;
    }

    public Canvas translate1Note(Canvas canvas, float noteWidth) {
        canvas.translate(noteWidth * 4, -(yBase - dy));
        return canvas;
    }

    public Canvas create2Note(float lineWidth, float lineHeight, float noteWidth, double note, double hand, Canvas canvas) {
        this.note = note;
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;


        scaleNoteDrawFlat(2, 3.5f, hand);

        // Translate canvas
        canvas.translate(noteWidth * 2, -(yBase - dy));

        return canvas;

    }

    public Canvas create3Note(float lineWidth, float lineHeight, float noteWidth, double note, double hand, Canvas canvas) {
        this.note = note;
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;


        scaleNoteDrawFlat(3, 3.5f, hand);

        // Translate canvas
        canvas.translate(noteWidth * 3, -(yBase - dy));

        return canvas;
    }

    public float dot3note(float lineWidth, float lineHeight, double note) {
        int intNote = (int) Math.ceil(note);
        int index = (intNote + OCTAVE) % OCTAVE;
        int octave = intNote / OCTAVE;
        yBase = lineHeight * 14;
        dy = (octave * lineHeight * 3.5f) + (offset[index] * (lineHeight / 2));
        return yBase - dy;
    }

    public Canvas create4Note(float lineWidth, float lineHeight, float noteWidth, double note, double hand, Canvas canvas) {
        this.note = note;
        this.hand = hand;
        this.canvas = canvas;
        this.lineHeight = lineHeight;
        this.lineWidth = lineWidth;


        scaleNoteDrawFlat(4, 3.5f, hand);

        Log.v("noteWidth2", noteWidth + "," + dy);
        // Translate canvas
        canvas.translate(noteWidth, -(yBase - dy));

        return canvas;
    }

//    public Canvas create6Note(float lineWidth, float lineHeight, float noteWidth, double note1, double note2, double note3, double hand, Canvas canvas) {
//        this.note1 = note1;
//        this.note2 = note2;
//        this.note3 = note3;
//        this.hand = hand;
//        this.canvas = canvas;
//        this.lineHeight = lineHeight;
//        this.lineWidth = lineWidth;
//        float diff13;
//        float diff12;
//        float diff23;
//
//        float tailHeight1 = 3.5f;
//        float tailHeight2 = 3.5f;
//        float tailHeight3 = 3.5f;
//        float shortest = 1.5f;
//
//        float middleNote = 0.5f;
//        float sideNote = 1;
//
//        boolean upper = tailIsUpper(8);
//
//        Log.v("aaaaaupper",upper+"");
//
//        diff12 = (noteDiff((float) note1, (float) note2)) / 2;
//        diff13 = (noteDiff((float) note1, (float) note3)) / 2;
//        diff23 = (noteDiff((float) note2, (float) note3)) / 2;
//
//        Log.v("aaaaadifference", diff12 + "," + diff13 + "," + diff23);
//
//        if (diff12 == 0) {
//            if (diff23 > 2) {
//                tailHeight1 = diff23 + shortest;
//                tailHeight2 = diff23 + shortest;
//                tailHeight3 = shortest;
//            } else if (diff23 > 0) {
//                tailHeight3 = tailHeight3 - diff23;
//            } else if (diff23 < -2) {
//                tailHeight1 = shortest;
//                tailHeight2 = shortest;
//                tailHeight3 = diff23 + shortest;
//            } else if (diff23 < 0) {
//                tailHeight1 = tailHeight1 + diff23;
//                tailHeight2 = tailHeight2 + diff23;
//            }
//        } else if (diff23 == 0) {
//            if (diff12 > 2) {
//                tailHeight1 = diff12 + shortest;
//                tailHeight2 = shortest;
//                tailHeight3 = shortest;
//            } else if (diff12 > 0) {
//                tailHeight2 = tailHeight2 - diff12;
//                tailHeight3 = tailHeight3 - diff12;
//            } else if (diff12 < -2) {
//                tailHeight1 = shortest;
//                tailHeight2 = diff12 + shortest;
//                tailHeight3 = diff12 + shortest;
//            } else if (diff12 < 0) {
//                tailHeight1 = tailHeight1 + diff12;
//            }
//        } else if (diff12 > 0 && diff23 < 0) {
//            if (diff12 <= 2 && diff23 >= -2) {
//                if (diff13 == 0) {
//                    tailHeight2 = tailHeight2 - diff12;
//                } else if (diff12 > (-diff23)) {
//                    tailHeight2 = tailHeight2 - diff12;
//                    tailHeight3 = tailHeight3 - diff13;
//                } else if (diff12 < (-diff23)) {
//                    tailHeight1 = tailHeight1 - diff13;
//                    tailHeight2 = tailHeight2 + diff23;
//                }
//            } else {
//                if (diff13 == 0) {
//                    tailHeight1 = diff12 + shortest;
//                    tailHeight2 = shortest;
//                    tailHeight3 = diff12 + shortest;
//                } else if (diff12 > (-diff23)) {
//                    tailHeight1 = diff12 + shortest;
//                    tailHeight2 = shortest;
//                    tailHeight3 = -diff23 + shortest;
//                } else if (diff12 < (-diff23)) {
//                    tailHeight1 = diff12 + shortest;
//                    tailHeight2 = shortest;
//                    tailHeight3 = -diff23 + shortest;
//                }
//            }
//
//
//        } else if (diff12 < 0 && diff23 > 0) {
//            if (diff12 <= 2 && diff23 >= -2) {
//                if (diff13 == 0) {
//                    tailHeight1 = tailHeight1 - diff23;
//                    tailHeight3 = tailHeight2 - diff23;
//                } else {
//                    tailHeight1 = tailHeight1 + diff12;
//                    tailHeight3 = tailHeight3 - diff23;
//                }
//            } else {
//                if (diff13 == 0) {
//                    tailHeight1 = shortest;
//                    tailHeight2 = diff23 + shortest;
//                    tailHeight3 = shortest;
//                } else if (-diff12 > diff23) {
//                    tailHeight1 = shortest;
//                    tailHeight2 = -diff12 + shortest;
//                    tailHeight3 = -diff13 + shortest;
//                } else if (-diff12 < diff23) {
//                    tailHeight1 = diff13 + shortest;
//                    tailHeight2 = diff23 + shortest;
//                    tailHeight3 = shortest;
//                }
//            }
//        } else if (diff12 > 0 && diff23 > 0) {
//            if (diff13 > 2) {
//                tailHeight1 = diff13 + shortest - sideNote;
//                tailHeight2 = diff23 + shortest - middleNote;
//                tailHeight3 = shortest;
//            } else {
//                tailHeight2 = tailHeight2 - diff12 + middleNote;
//                tailHeight3 = tailHeight3 - diff13 + sideNote;
//            }
//        } else if (diff12 < 0 && diff23 < 0) {
//            if (diff13 < -2) {
//                tailHeight1 = shortest;
//                tailHeight2 = -diff12 + shortest - middleNote;
//                tailHeight3 = -diff13 + shortest - sideNote;
//            } else {
//                tailHeight1 = tailHeight1 + diff13 + sideNote;
//                tailHeight2 = tailHeight2 + diff23 + middleNote;
//
//            }
//        }
//
//        Log.v("aaaaatailHeight",tailHeight1+","+tailHeight2+","+tailHeight3);
//        this.note = note1;
//        scaleNoteDrawFlat(6, tailHeight1);
//
//        //Draw the line connect 3 note
//        if ((diff12 > 0 && diff23 > 0 && diff13 <= 2)) {
//            if (upper) {
//                canvas.drawLine(lineHeight / 1.5f - 1, -lineHeight * tailHeight1,
//                        noteWidth / 1.5f + (lineHeight / 1.5f) + 1, -lineHeight * (tailHeight1 + 1), paintTail);
//            } else {
//                canvas.drawLine((lineHeight / 1.5f - 1) - lineHeight * 1.4f, lineHeight * tailHeight1,
//                        (noteWidth / 1.5f + (lineHeight / 1.5f) + 1) - lineHeight * 1.4f, lineHeight * (tailHeight1 - 1), paintTail);
//            }
//        } else if ((diff12 < 0 && diff23 < 0 && diff13 >= -2)) {
//            if (upper) {
//                canvas.drawLine(lineHeight / 1.5f - 1, -lineHeight * tailHeight1,
//                        noteWidth / 1.5f + (lineHeight / 1.5f) + 1, -lineHeight * (tailHeight1 - 1), paintTail);
//            } else {
//                canvas.drawLine((lineHeight / 1.5f - 1) - lineHeight * 1.4f, lineHeight * tailHeight1,
//                        (noteWidth / 1.5f + (lineHeight / 1.5f) + 1) - lineHeight * 1.4f, lineHeight * (tailHeight1 + 1), paintTail);
//            }
//        } else {
//
//            if (upper) {
//                canvas.drawLine(lineHeight / 1.5f - 1, -lineHeight * tailHeight1,
//                        noteWidth / 1.5f + (lineHeight / 1.5f) + 1, -lineHeight * tailHeight1, paintTail);
//            } else {
//                canvas.drawLine((lineHeight / 1.5f - 1) - lineHeight * 1.4f, lineHeight * tailHeight1,
//                        (noteWidth / 1.5f + (lineHeight / 1.5f) + 1) - lineHeight * 1.4f, lineHeight * tailHeight1, paintTail);
//            }
//        }
//
//
//        canvas.translate(noteWidth / 3, -(yBase - dy));
//
//        this.note = note2;
//        scaleNoteDrawFlat(6, tailHeight2);
//        canvas.translate(noteWidth / 3, -(yBase - dy));
//
//        this.note = note3;
//        scaleNoteDrawFlat(6, tailHeight3);
//        canvas.translate(noteWidth / 3, -(yBase - dy));
//
//        return canvas;
//    }

    public Canvas create8Note(float lineWidth, float lineHeight, float noteWidth, double note1, double note2, double hand, Canvas canvas) {
        this.note1 = note1;
        this.note2 = note2;
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

        if (note1 > note2 || note1 == note2) {
            max = (float) note1;
            min = (float) note2;
        } else {
            min = (float) note1;
            max = (float) note2;
        }

        float noteDiff = noteDiff(min, max);
        noteDiff = noteDiff / 2;

        if (noteDiff < 1) {
            theLine = noteDiff;
        } else if (noteDiff < 2.5) {
            theLine = 1;
            if (max == note1) {
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
            if (max == note1) {
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

        this.note = note1;
        scaleNoteDrawFlat(8, tailHeight1, hand);

        if (max == note2) {
            if (upper)
                canvas.drawLine(lineHeight / 1.5f - 1, -lineHeight * tailHeight1,
                        noteWidth / 2 + (lineHeight / 1.5f) + 1, -lineHeight * (tailHeight1 + theLine), paintTail);
            else
                canvas.drawLine((lineHeight / 1.5f - 1) - lineHeight * 1.4f, lineHeight * tailHeight1,
                        (noteWidth / 2 + (lineHeight / 1.5f) + 1) - lineHeight * 1.4f, lineHeight * (tailHeight1 - theLine), paintTail);
        } else {
            if (upper)
                canvas.drawLine(lineHeight / 1.5f - 1, -lineHeight * tailHeight1,
                        noteWidth / 2 + (lineHeight / 1.5f) + 1, -lineHeight * (tailHeight1 - theLine), paintTail);
            else
                canvas.drawLine((lineHeight / 1.5f - 1) - lineHeight * 1.4f, lineHeight * tailHeight1,
                        (noteWidth / 2 + (lineHeight / 1.5f) + 1) - lineHeight * 1.4f, lineHeight * (tailHeight1 + theLine), paintTail);
        }
        // Translate canvas
        canvas.translate(noteWidth / 2, -(yBase - dy));

        this.note = note2;
        scaleNoteDrawFlat(8, tailHeight2, hand);


        // Translate canvas
        canvas.translate(noteWidth / 2, -(yBase - dy));

        return canvas;
    }

    public Canvas create16Note(float lineWidth, float lineHeight, float noteWidth, double note1, double note2, double note3, double note4, double hand, Canvas canvas) {
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.hand = hand;
        return canvas;
    }

    //scale note head and draw flat sharp
    public void scaleNoteDrawFlat(int noteType, float tailHeight, double hand) {


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
        if (hand == 0) {
            yBase = lineHeight * 8;
        }
        else
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
            drawLeger(noteType, note);
        }

        if (noteType > 3)
            canvas.drawPath(notepath, paint);

        else if (noteType == 2 || noteType == 3) {
            canvas.drawPath(notepath, paint423);

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
            drawTail(tailHeight, noteType);

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
    public void drawTail(float tailHeight, int noteType) {
        if (tailIsUpper(noteType))
            canvas.drawLine(lineHeight / 1.5f, 0,
                    lineHeight / 1.5f, -lineHeight * tailHeight, paint);
        else
            canvas.drawLine(-lineHeight / 1.5f, 0,
                    -lineHeight / 1.5f, lineHeight * tailHeight, paint);

    }

    //whether tail is upper
    public boolean tailIsUpper(int noteType) {
        boolean upper = true;

        if (noteType > 4) {
            if (noteType == 6) {
                if (hand == 0) {
                    upper = false;
                    if (note1 <= 36 && note2 <= 36 && note3 <= 36) {
                        upper = true;
                    }
                } else if ((note1 > 58 && note2 > 58) || (note1 > 58 && note3 > 58) || (note2 > 58 && note3 > 58)) {
                    upper = false;
                }

            } else if (noteType == 8) {
                if (hand == 0) {
                    upper = false;
                    if (note1 <= 36 && note2 <= 36) {
                        upper = true;
                    }
                } else if (note1 > 58 && note2 > 58) {
                    upper = false;
                }

            }
//              else if (noteType == 16) {
//                if (hand == 0) {
//                    upper = false;
//                    if (note1 <= 36 && note2 <= 36 && note3 <= 36) {
//                        upper = true;
//                    }
//                } else if (note1 > 58 && note2 > 58 && note3 > 58) {
//                    upper = false;
//                }
//
//            }
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
    protected void drawLeger(int noteType, Double note) {
        if (noteType > 1)
            canvas.drawLine(-lineHeight, 0, lineHeight, 0, paint);

    }

    // On draw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

