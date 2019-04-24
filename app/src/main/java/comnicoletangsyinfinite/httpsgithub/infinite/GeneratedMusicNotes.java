package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.Log;

import java.util.ArrayList;

public class GeneratedMusicNotes {
    private double tempo[] = {60, 80, 120}; //bpm
    private double beat[] = {3, 4}; //拍子記號 44拍 or 34拍
    private double[] noteIn4 = {8, 4, 3, 2, 1}; //44拍 choic
    private double[] noteIn3 = {6, 4, 3, 2, 1}; //34拍 choice
    private double[] noteIn;
    private ArrayList<Double> note = new ArrayList<>();
    private ArrayList<ArrayList<Double>> pianoSheet = new ArrayList<>();
    private double theBeat;
    private double countBar = 0;
    private double hand;
    private int[] flat = {6, 2, 5, 1, 4, 0, 3};
    private int[] sharp = {3, 0, 4, 1, 5, 2, 6};
    private int[] flatOrSharp;
    private int[] howMany = {4, 2, 3, 1};
    private boolean flatSharp = false;
    private double previousNote = -1;
    private double[] keys = {48, 50, 52, 53, 55, 57, 59, 60, 62, 64};

    public double getTempo(){
       return pianoSheet.get(0).get(0);
    }

    public double getBeat(){
        return pianoSheet.get(0).get(1);
    }

    public double getSharpFlat(){
        return pianoSheet.get(1).get(0);
    }

    public double getKey(){
        return pianoSheet.get(1).get(1);
    }

    public double getHand(){
        return pianoSheet.get(2).get(0);
    }


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
        pianoSheet.get(2).add((double) 0);//not yet need this column

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
        double countBeat = 0;
        while (column < 6 * (pianoSheet.get(0).get(1))) {
            noteTime = noteIn[(int) Math.floor(Math.random() * (pianoSheet.get(0).get(1) - countBeat))];
            if (noteTime <= 4) {

                getNote(noteNum, noteTime);
                column = column + howMany[(int) noteTime - 1];
                noteNum++;
                countBeat = countBeat + howMany[(int) noteTime - 1];

                if (countBeat == pianoSheet.get(0).get(1))
                    countBeat = 0;
            } else {
                if (noteTime == 6) {
                    for (int i = 0; i < 3; i++) {
                        getNote(noteNum, noteTime);
                        noteNum++;
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        getNote(noteNum, noteTime);
                        noteNum++;
                    }
                }
                column++;
                countBeat++;
                if (countBeat == pianoSheet.get(0).get(1))
                    countBeat = 0;
            }
        }
    }

    //gen a note and insert into piano sheet
    public void getNote(int noteNum, double noteTime) {
        double aNote;
        aNote = genAnote(previousNote);
        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(noteNum).add(aNote);
        pianoSheet.get(noteNum).add(noteTime);
    }

    //gen a note -3 to +3 of the previous note
    //if the first note, random gen 0-10 (C4-E5)
    public double genAnote(double preNote) {
        double aNote = 0;
        int random = 0;
        if (preNote < 0) {
            aNote = Math.floor(Math.random() * 10);
        } else {
            if (preNote > 6) {
                random = (int) Math.floor(Math.random() * (13 - preNote));
            } else if (preNote < 3) {
                random = (int) ((Math.floor(Math.random() * (4 + preNote))) + (3 - preNote));
            } else {
                random = (int) Math.floor(Math.random() * 7);
            }
            aNote = preNote + random - 3;
        }
        previousNote = aNote;
        return convertNote(aNote);
    }

    public double convertNote(double aNote) {
        double type;
        double convertedNote;

        if (pianoSheet.get(1).get(0) == 0) {
            flatOrSharp = flat;
            type = -0.5f;
        } else {
            flatOrSharp = sharp;
            type = 1;
        }

        for (int i = 0; i < pianoSheet.get(1).get(1); i++) {
            if ((aNote == (double) flatOrSharp[i]) || (aNote - 7 == (double) flatOrSharp[i]) || (aNote + 7 == (double) flatOrSharp[i])) {
                flatSharp = true;
            }
        }
        if (flatSharp == true) {
            convertedNote = keys[(int) aNote] + type;

        } else {
            convertedNote = keys[(int) aNote];
        }
        flatSharp = false;
        return convertedNote;
    }


}
