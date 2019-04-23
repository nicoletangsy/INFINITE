package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.Log;

import java.util.ArrayList;

public class GeneratedMusicNotes {
    private double tempo[] = {60, 80, 120}; //bpm
    private double beat[] = {3, 4}; //拍子記號 44拍 or 34拍
    private double[] noteIn4 = {1, 2, 3, 4, 8}; //44拍 choic
    private double[] noteIn3 = {1, 2, 3, 4, 6}; //34拍 choice
    private double[] noteIn;
    private ArrayList<Double> note = new ArrayList<>();
    private ArrayList<ArrayList<Double>> pianoSheet = new ArrayList<>();
    private double theBeat;
    private double countBar = 0;
    private double hand;
    private int[] flat = {11, 6, 2, 5, 1, 4, 0, 3};
    private int[] sharp = {11, 3, 0, 4, 1, 5, 2, 6};
    private int[] flatOrSharp;
    private int[] howMany = {4,2,3,1};


    public GeneratedMusicNotes(double hand) {

        this.hand = hand;


        theBeat = addBeat();
        setNoteIn(theBeat);

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(0).add(addTempo());
        pianoSheet.get(0).add(theBeat);

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(1).add(addFlatSharp());
        pianoSheet.get(1).add(addKey());

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(2).add(hand);
        pianoSheet.get(2).add((double) 0);

        genSheet();
    }

    public void setNoteIn(double theBeat) {
        if (theBeat == 3) {
            noteIn = noteIn3;
        } else noteIn = noteIn4;
    }

    public double addTempo() {
        return tempo[(int) (Math.floor(Math.random() * 3))];
    }

    public double addBeat() {
        return beat[(int) Math.round(Math.random())];
    }

    public double addFlatSharp() {
        return Math.round(Math.random());
    }

    public double addKey() {
        return Math.floor(Math.random() * 8);
    }

    public ArrayList<ArrayList<Double>> getPianoSheet() {
        return pianoSheet;
    }

    public void genSheet() {
        double noteTime;
        int column = 0;
        int noteNum = 3;
        while (column <= 6 * (pianoSheet.get(0).get(1))) {
            noteTime = noteIn[(int) Math.floor(Math.random() * 5)];
            if (noteTime <= 4) {

                getNote(noteNum, noteTime);


                column = column + howMany[(int)noteTime-1];
                Log.v("testestifnoteNum",""+noteNum);
                Log.v("testestifnoteTime",""+noteTime);
                Log.v("testestifcolumn",""+column);
                noteNum++;

            } else {
                if (noteTime == 6) {
                    for (int i = 0; i < 3; i++) {
                        getNote(noteNum, noteTime);

                        Log.v("testestelseifnoteNum",""+noteNum);
                        Log.v("testestelseifnoteTime",""+noteTime);
                        noteNum++;
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        getNote(noteNum, noteTime);

                        Log.v("testestelselsenoteNum",""+noteNum);
                        Log.v("testestelselsenoteTime",""+noteTime);
                        noteNum++;
                    }
                }
                column++;
                Log.v("testestelsecolumn",""+column);
            }

        }
        Log.v("testesthihihi",""+pianoSheet);
    }

    //gen a note and insert into piano sheet
    public void getNote(int noteNum, double noteTime) {
        double aNote;
        aNote = genAnote(pianoSheet.get(noteNum - 1).get(0));
        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(noteNum).add(aNote);
        pianoSheet.get(noteNum).add(noteTime);
        Log.v("aiaiaiaiainoteNum",""+noteNum);
        Log.v("testesthihihi",""+pianoSheet);
    }

    //gen a note -3 to +3 of the previous note
    //if the first note, random gen 0-10 (C4-E5)
    public double genAnote(double preNote) {
        double aNote = 0;
        if (preNote < 20) {
            aNote = Math.floor(Math.random() * 11);
            Log.v("aiaiaiaiaiaNote",""+aNote);
        } else {
            int random = (int) Math.floor(Math.random() * 7);
            aNote = preNote-48 + random - 3;
            Log.v("aiaiaiaiaiaNote",""+aNote);
        }
        return convertNote(aNote);
    }

    //////////////////////////////////////////////////flatSharp not yet done/////////////////////////////////////////////


    public double convertNote(double aNote) {
//        boolean flatSharp = false;
        double type;
        double convertedNote;
        if (pianoSheet.get(1).get(0) == 0) {
            flatOrSharp = flat;
            type = -0.5f;
        } else {
            flatOrSharp = sharp;
            type = 1;
        }

//        for (int i = 0; i <= 100; i++) {
//            if (aNote == (double) flatOrSharp[i] || aNote - 7 == (double) flatOrSharp[i] || aNote + 7 == (double) flatOrSharp[i]) {
//                flatSharp = true;
//            }
//        }
//
//        if (flatSharp = true) {
//            convertedNote = aNote + 48 + type;
//        } else
            convertedNote = aNote + 48;
        Log.v("aiaiaiaiconvertedNote",""+convertedNote);
        return convertedNote;
    }


}
