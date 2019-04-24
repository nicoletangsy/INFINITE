package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;

public class GeneratedMusicNotes {
    private int tempo = 0; //bpm
    private int timeSignature[] = {4, 4}; //拍子記號 44拍
    private int bar = 0; //the number of bars
    private int total = 2; //the total number of notes;
    private int totalNotes[] = new int[bar]; //the no of notes in each bar
    private int[] noteDuration = {1, 2, 4, 8, 16};
    private ArrayList<aNote> allNotes = new ArrayList<aNote>();

    public void addNote(aNote aNote) {
        allNotes.add(aNote);
    }

    public int getTempo() { return this.tempo; }
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

    public GeneratedMusicNotes () {
        randomGenerated();
    }

    //Constructor for testing
    public GeneratedMusicNotes(int tempo, int timeSignature_count, int timeSignature_note) {
        this.tempo = tempo;
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
    }

    private void randomGenerated() {
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
        int duration = (int) Math.random()*5;
        return noteDuration[duration];
    }

    private double randomNote() {
        int rand = (int)(Math.random()* 13 + 48); //Note: C4~C5
        int rand2 = (int)(Math.random()*2); //determine sharp/flat
        if (rand2==0) {
            return (double)rand;
        } else {
            return rand+0.5;
        }
    }
}
