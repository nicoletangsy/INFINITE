package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;


public class RecordedMusicNotes {
    private ArrayList<aNote> Notes = new ArrayList<aNote>();
    private ArrayList<aNote> ProcessedNotes = new ArrayList<aNote>();
    private ArrayList<ArrayList<Double>> pianoSheet = new ArrayList<>();

    private int tempo = 60; //GENERATED_MUSIC_NOTES.getTempo();
    private int timeSignature_note = 4; //GENERATED_MUSIC_NOTES.getTimeSignature()[1];

    public RecordedMusicNotes() {}

    public String getAllNotes() {
        String list = "Notes: ";
        list = list + Notes.size()+ ", ";
        for (int i=0; i<Notes.size(); i++) {
            String dBSPL = String.format("%.1f", Notes.get(i).getDbSPL());
            String time = String.format("%.2f", Notes.get(i).getTimeStamp());
            list = list + "[" + Notes.get(i).getNote() + ", " + dBSPL + ", " + time + "] ";
        }
        list = list + "\n ProcessedNotes: ";
        for (int i=0; i<ProcessedNotes.size(); i++) {
            String dBSPL = String.format("%.1f", ProcessedNotes.get(i).getDbSPL());
            String duration = String.format("%.2f", ProcessedNotes.get(i).getTimeStamp());
            list = list + "[" + ProcessedNotes.get(i).getNote() + ", " + ProcessedNotes.get(i).getNoteDuration() + ", " + dBSPL + ", " + duration + "] ";
        }
        return list;
    }

    public void addNotes (aNote aNote) {
        Notes.add(aNote);
    }

    public ArrayList<ArrayList<Double>> getPianoSheetView(){
        for (int i=0; i<Notes.size(); i++) {
            pianoSheet.get(3+i).add(ProcessedNotes.get(i).getNote());
            pianoSheet.get(3+i).add((double)ProcessedNotes.get(i).getNoteDuration());

        }
        return pianoSheet;
    }

    public void ProcessNote() {
        double curNote, curdB, endTime, prepdB, prepNote, startTime;
        boolean isFirst = true;
        int count = 0;
        prepdB = Notes.get(0).getDbSPL();
        prepNote = Notes.get(0).getNote();
        startTime = Notes.get(0).getTimeStamp();
        for (int i=0; i<Notes.size(); i++) {
            if (isFirst) {
                aNote newNote = new aNote(prepNote);
                newNote.setDbSPL(prepdB);
                ProcessedNotes.add(newNote);
                isFirst = false;
            } else {
                curdB = Notes.get(i).getDbSPL();
                curNote = Notes.get(i).getNote();
                if (prepNote!=curNote) {
                    endTime = Notes.get(i).getTimeStamp();
                    double duration = endTime-startTime;
                    int noteDuration = calculateNoteDuration(duration);
                    if (noteDuration>0) {
                        ProcessedNotes.get(count).setNoteDuration(noteDuration);
                        startTime = Notes.get(i).getTimeStamp();
                        prepNote = curNote;
                        prepdB = curdB;
                        aNote newNote = new aNote(prepNote, prepdB, startTime);
                        ProcessedNotes.add(newNote);
                        count++;
                    }
                }
                if (prepNote==curNote && prepdB<curdB) {
                    endTime = Notes.get(i).getTimeStamp();
                    double duration = endTime-startTime;
                    int noteDuration = calculateNoteDuration(duration);
                    if (noteDuration>0) {
                        ProcessedNotes.get(count).setNoteDuration(noteDuration);
                        startTime = Notes.get(i).getTimeStamp();
                        prepNote = curNote;
                        prepdB = curdB;
                        aNote newNote = new aNote(prepNote, prepdB, startTime);
                        ProcessedNotes.add(newNote);
                        count++;
                    }
                }
            }
        }
    }

    public int calculateNoteDuration (double duration) {
        double oneNoteDuration = 60 / tempo * timeSignature_note;
        double NotesDuration[] = new double[5];
        NotesDuration[0] = oneNoteDuration / 1.0; //one Whole note time
        NotesDuration[1] = oneNoteDuration / 2.0; //one Half note time
        NotesDuration[2] = oneNoteDuration / 4.0; //one Quarter note time
        NotesDuration[3] = oneNoteDuration / 8.0; //one Eighth note time
        NotesDuration[4] = oneNoteDuration / 16.0; //one 16th note time
        if (duration>NotesDuration[4] && duration<=NotesDuration[3]) {
            return 8;
        }
        if (duration>NotesDuration[3] && duration<=NotesDuration[2]) {
            return 4;
        }
        if (duration>NotesDuration[2] && duration<=NotesDuration[1]) {
            return 2;
        }
        if (duration>NotesDuration[1] && duration<=NotesDuration[0]) {
            return 1;
        }
        return 0;
    }

    public void removeAllRecords() {
        Notes.clear();
        ProcessedNotes.clear();
    }
}
