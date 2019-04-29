package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.AndroidRuntimeException;
import android.util.Log;

import java.util.ArrayList;

public class GeneratedMusicNotes {
    private int timeSignature[] = {4, 4}; //拍子記號 44拍
    private int bar = 0; //the number of bars
    private int total = 2; //the total number of notes;
    private int totalNotes[] = new int[bar]; //the no of notes in each bar
    private int[] noteDuration = {1, 2, 4, 8, 16};
    private ArrayList<aNote> allNotes = new ArrayList<aNote>();
    private double tempo[] = {60, 80, 120}; //bpm
    private double[] noteIn4 = {8, 4, 3, 2, 1}; //44拍 choice
    private ArrayList<ArrayList<Double>> pianoSheet = new ArrayList<>();
    private int[] flat = {6, 2, 5, 1, 4, 0, 3};
    private int[] sharp = {3, 0, 4, 1, 5, 2, 6};
    private int[] flatOrSharp;
    private int[] howMany = {4, 2, 3, 1};
    private boolean flatSharp = false;
    private double previousNote = -1;
    private double[] rightKeys = {48, 50, 52, 53, 55, 57, 59, 60, 62, 64};
    private double[] leftKeys = {33, 35, 36, 38, 40, 41, 43, 45, 47, 48};
    private double[] keys;
    private double diff = 0;
    private double bpm;
    private double hand;
    private double sharpFlat;
    private double key;

    public int getBar() { return bar; }
    public int getTotal() { return total; }
    public double getTempo(){ return pianoSheet.get(0).get(0);}
    public double getBeat(){ return pianoSheet.get(0).get(1); }
    public double getSharpFlat(){ return pianoSheet.get(1).get(0); }
    public double getKey(){ return pianoSheet.get(1).get(1); }
    public double getHand(){ return pianoSheet.get(2).get(0); }
    public double getANoteDuration(int i) {
        return pianoSheet.get(i).get(1);
    }

    public void setKeys(double hand) {
        if (hand == 0) {
            keys = leftKeys;
            diff=1;
        } else keys = rightKeys;
    }

    //hardCodeSheet or hardCodeSheet2
    public GeneratedMusicNotes() {
//        hardCodeSheet2();
    }
    //  correct
//    public void generateSheet1() {
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(0).add((double)60);
//        pianoSheet.get(0).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(1).add((double)0);
//        pianoSheet.get(1).add((double)0);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(2).add((double)1);
//        pianoSheet.get(2).add((double)0);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(3).add((double)48);
//        pianoSheet.get(3).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(4).add((double)50);
//        pianoSheet.get(4).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(5).add((double)52);
//        pianoSheet.get(5).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(6).add((double)52);
//        pianoSheet.get(6).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(7).add((double)55);
//        pianoSheet.get(7).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(8).add((double)53);
//        pianoSheet.get(8).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(9).add((double)53);
//        pianoSheet.get(9).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(10).add((double)53);
//        pianoSheet.get(10).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(11).add((double)55);
//        pianoSheet.get(11).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(12).add((double)57);
//        pianoSheet.get(12).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(13).add((double)60);
//        pianoSheet.get(13).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(14).add((double)60);
//        pianoSheet.get(14).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(15).add((double)64);
//        pianoSheet.get(15).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(16).add((double)62);
//        pianoSheet.get(16).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(17).add((double)60);
//        pianoSheet.get(17).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(18).add((double)57);
//        pianoSheet.get(18).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(19).add((double)55);
//        pianoSheet.get(19).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(20).add((double)55);
//        pianoSheet.get(20).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(21).add((double)53);
//        pianoSheet.get(21).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(22).add((double)53);
//        pianoSheet.get(22).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(23).add((double)53);
//        pianoSheet.get(23).add((double)4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(24).add((double)55);
//        pianoSheet.get(24).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(25).add((double)53);
//        pianoSheet.get(25).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(26).add((double)55);
//        pianoSheet.get(26).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(27).add((double)57);
//        pianoSheet.get(27).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(28).add((double)57);
//        pianoSheet.get(28).add((double) 2);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(29).add((double)55);
//        pianoSheet.get(29).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(30).add((double)53);
//        pianoSheet.get(30).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(31).add((double)53);
//        pianoSheet.get(31).add((double) 2);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(32).add((double)53);
//        pianoSheet.get(32).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(33).add((double)48);
//        pianoSheet.get(33).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(34).add((double)50);
//        pianoSheet.get(34).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(35).add((double)52);
//        pianoSheet.get(35).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(36).add((double)55);
//        pianoSheet.get(36).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(37).add((double)53);
//        pianoSheet.get(37).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(38).add((double)52);
//        pianoSheet.get(38).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(39).add((double)53);
//        pianoSheet.get(39).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(40).add((double)55);
//        pianoSheet.get(40).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(41).add((double)53);
//        pianoSheet.get(41).add((double)8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(42).add((double)52);
//        pianoSheet.get(42).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(43).add((double)48);
//        pianoSheet.get(43).add((double) 2);
//
//    }
        //  wrong
//    public void generateSheet2() {
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(0).add((double)60);
//        pianoSheet.get(0).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(1).add((double)0);
//        pianoSheet.get(1).add((double)2);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(2).add((double)1);
//        pianoSheet.get(2).add((double)0);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(3).add((double)58);
//        pianoSheet.get(3).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(4).add((double)57);
//        pianoSheet.get(4).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(5).add((double)58);
//        pianoSheet.get(5).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(6).add((double)57);
//        pianoSheet.get(6).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(7).add((double)55);
//        pianoSheet.get(7).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(8).add((double)53);
//        pianoSheet.get(8).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(9).add((double)51);
//        pianoSheet.get(9).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(10).add((double)50);
//        pianoSheet.get(10).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(11).add((double)52);
//        pianoSheet.get(11).add((double) 2);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(12).add((double)52);
//        pianoSheet.get(12).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(13).add((double)52);
//        pianoSheet.get(13).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(14).add((double)53);
//        pianoSheet.get(14).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(15).add((double)55);
//        pianoSheet.get(15).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(16).add((double)55);
//        pianoSheet.get(16).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(17).add((double)53);
//        pianoSheet.get(17).add((double) 2);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(18).add((double)57);
//        pianoSheet.get(18).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(19).add((double)60);
//        pianoSheet.get(19).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(20).add((double)58);
//        pianoSheet.get(20).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(21).add((double)57);
//        pianoSheet.get(21).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(22).add((double)53);
//        pianoSheet.get(22).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(23).add((double)52);
//        pianoSheet.get(23).add((double)8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(24).add((double)50);
//        pianoSheet.get(24).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(25).add((double)51);
//        pianoSheet.get(25).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(26).add((double)53);
//        pianoSheet.get(26).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(27).add((double)50);
//        pianoSheet.get(27).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(28).add((double)48);
//        pianoSheet.get(28).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(29).add((double)50);
//        pianoSheet.get(29).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(30).add((double)51);
//        pianoSheet.get(30).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(31).add((double)53);
//        pianoSheet.get(31).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(32).add((double)51);
//        pianoSheet.get(32).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(33).add((double)55);
//        pianoSheet.get(33).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(34).add((double)53);
//        pianoSheet.get(34).add((double) 4);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(35).add((double)55);
//        pianoSheet.get(35).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(36).add((double)57);
//        pianoSheet.get(36).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(37).add((double)60);
//        pianoSheet.get(37).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(38).add((double)58);
//        pianoSheet.get(38).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(39).add((double)58);
//        pianoSheet.get(39).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(40).add((double)57);
//        pianoSheet.get(40).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(41).add((double)62);
//        pianoSheet.get(41).add((double)8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(42).add((double)60);
//        pianoSheet.get(42).add((double) 8);
//
//        pianoSheet.add(new ArrayList<Double>());
//        pianoSheet.get(43).add((double)58);
//        pianoSheet.get(43).add((double) 2);
//
//
//
//    }
        public void generateSheet(double tempo, double hand, double sharpFlat, double key){

        if(tempo ==-1){
            this.bpm = addTempo();
        }
        else{
            this.bpm = tempo;
        }

        if(hand ==-1){
            this.hand = addHand();
        }
        else{
            this.hand = hand;
        }

        if(sharpFlat ==-1){
            this.sharpFlat = addFlatSharp();
        }
        else{
            this.sharpFlat = sharpFlat;
        }

        if(key ==-1){
            this.key = addKey();
        }
        else{
            this.key = key;
        }

        setKeys(this.hand);

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(0).add(this.bpm);
        pianoSheet.get(0).add((double) 4);

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(1).add(this.sharpFlat);
        pianoSheet.get(1).add(this.key);

        pianoSheet.add(new ArrayList<Double>());
        pianoSheet.get(2).add(this.hand);
        pianoSheet.get(2).add((double) 0);//not yet need this column


        genSheet();
    }

    public double addTempo() {
        return tempo[(int) (Math.floor(Math.random() * 3))];
    }

    public double addHand(){
        return (Math.floor(Math.random() * 2));
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
        while (column < 8 * (pianoSheet.get(0).get(1))) {
            noteTime = noteIn4[(int) Math.floor(Math.random() * (pianoSheet.get(0).get(1) - countBeat))];
            if (noteTime <= 4) {

                getNote(noteNum, noteTime);
                column = column + howMany[(int) noteTime - 1];
                noteNum++;
                countBeat = countBeat + howMany[(int) noteTime - 1];

                if (countBeat == pianoSheet.get(0).get(1))
                    countBeat = 0;
            } else {

                for (int i = 0; i < 2; i++) {
                    getNote(noteNum, noteTime);
                    noteNum++;
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
            if ((aNote -(diff*2) == (double) flatOrSharp[i]) || (aNote - 7 -(diff*2) == (double) flatOrSharp[i]) || (aNote + 7  -(diff*2)== (double) flatOrSharp[i])) {
                flatSharp = true;
                Log.v("bbbbbflatSharp",""+aNote+","+i);
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
