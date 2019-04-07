package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;

public class GeneratedMusicNotes {
    private int tempo = 0; //bpm
    private int timeSignature[] = {4, 4}; //拍子記號 44拍
    private int bar = 0; //the number of bars
    private int total = 2; //the total number of notes;
    private int totalNotes[] = new int[bar]; //the no of notes in each bar
    private int[] noteDuration = {1, 2, 4, 8, 16, 32, 64};
    private float[] maxNotes; //max. of notes added in a bar
    private ArrayList<aNote> allNotes = new ArrayList<aNote>();
    //ArrayList<Notes> notesArrayList = new ArrayList<>();
    //private double allNotes[][]={{48.5,4},{60,4}};

    public int getTempo() { return this.tempo; }
    public int[] getTimeSignature() { return timeSignature; }
    public int getBar() { return bar; }
    public int getTotal() { return total; }
    public int[] getTotalNotes() { return totalNotes; }

    public aNote getNote(int i) {
        return allNotes.get(i);
    }
    public ArrayList<aNote> getNotesArrayList() {
        /*for (int i = 0; i <allNotes.length; i++) {
            notesArrayList.add(new Notes(this.getContext()));
            canvas = notesArrayList.get(i).createNote(lineWidth, lineHeight, margin, allNotes[i][0], 4, canvas, paint);

        }*/
        return this.allNotes;
    }

    public GeneratedMusicNotes() {
        aNote newNote = new aNote(48.5, 4);
        aNote newNote2 = new aNote(60, 4);
        addNote(newNote);
        addNote(newNote2);
        //randomGenerated();
    }

    public void addNote(aNote aNote) {
        allNotes.add(aNote);
    }

    private void randomGenerated() {
        tempo = (int)(Math.random() * 110 + 70); // 70~180 bpm
        bar = (int)(Math.random() * 4 + 1); // 1~4 bars
        for (int i=0; i<bar; i++) {
            totalNotes[i] = (int) (Math.random() * 10 + 1);
            total += totalNotes[i];
        }
        for (int i=0; i<bar; i++) {
            for (int j=0; j<noteDuration.length; j++) {
                int temp = noteDuration[j]/timeSignature[1]*timeSignature[0];
                maxNotes[j] = temp;
            }
            do {
                int count = 0;
                for(int j=0; j<maxNotes.length; j++) {
                    if (maxNotes[j]>0) {
                        count++;
                    }
                }
                int rand = randomNoteDuration(count);
                aNote newNote = new aNote(randomNote(), rand);
            } while (!(maxNotes[0]==0&&maxNotes[1]==0&&maxNotes[2]==0&&maxNotes[3]==0&&maxNotes[4]==0&&maxNotes[5]==0&&maxNotes[6]==0));
        }
    }

    private int randomNoteDuration (int count) {
        int rand = (int)(Math.random() * count + (7 - count));
        return noteDuration[rand];
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
