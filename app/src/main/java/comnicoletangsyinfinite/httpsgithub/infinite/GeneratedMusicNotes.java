package comnicoletangsyinfinite.httpsgithub.infinite;

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

    public void addNote(aNote aNote) {
        allNotes.add(aNote);
    }

    public int[] getTimeSignature() { return timeSignature; }
    public int getBar() { return bar; }
    public int getTotal() { return total; }
    public int[] getTotalNotes() { return totalNotes; }
    public aNote getNote(int i) {
        return allNotes.get(i);
    }
    public ArrayList<aNote> getNotesArrayList() {
        return this.allNotes;
    }
    public int[] getAllNotesDuration () {
        int list[] = new int[allNotes.size()];
        for (int i=0; i<allNotes.size(); i++) {
            list[i] = allNotes.get(i).getNoteDuration();
        }
        return list;
    }
    public double getTempo(){ return pianoSheet.get(0).get(0);}
    public double getBeat(){ return pianoSheet.get(0).get(1); }
    public double getSharpFlat(){ return pianoSheet.get(1).get(0); }
    public double getKey(){ return pianoSheet.get(1).get(1); }
    public double getHand(){ return pianoSheet.get(2).get(0); }

    //public GeneratedMusicNotes () { randomGenerated(); }

    /*Constructor for testing
    public GeneratedMusicNotes(int timeSignature_count, int timeSignature_note) {
        this.timeSignature[0] = timeSignature_count;
        this.timeSignature[1] = timeSignature_note;
        addNote(new aNote(52,8));
        addNote(new aNote(50,8));
        addNote(new aNote(48,8));
        addNote(new aNote(50,8));
        addNote(new aNote(52,8));
        addNote(new aNote(52,8));
        addNote(new aNote(52,4));
        addNote(new aNote(50,8));
        addNote(new aNote(50,8));
        addNote(new aNote(50,4));
        addNote(new aNote(52,8));
        addNote(new aNote(55,8));
        addNote(new aNote(55,4));
    }*/

    /*private void randomGenerated() {
        tempo = (int)(Math.random() * 120 + 60); // 60~180 bpm
        bar = (int)(Math.random() * 4 + 1); // 1~4 bars
        double totalNotes = bar * timeSignature[0];
        do {
            double newNote = randomNote();
            int duration = randomNoteDuration();
            while (timeSignature[1]/duration>totalNotes) {
                duration = randomNoteDuration();
            }
            addNote(new aNote(newNote, duration));
            totalNotes -= duration;
        } while (totalNotes>0);
    }

    private int randomNoteDuration () {
        int duration = (int) Math.random() * 5;
        return noteDuration[duration];
    }*/
    public void setKeys(double hand) {
        if (hand == 0) {
            keys = leftKeys;
            diff=1;
        } else keys = rightKeys;
    }

    public GeneratedMusicNotes(double hand) {
    }

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
        return tempo[(int) (Math.floor(Math.random() * 2))];
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
