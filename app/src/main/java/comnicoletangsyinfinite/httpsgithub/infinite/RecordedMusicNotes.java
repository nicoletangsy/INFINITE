package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;

import static comnicoletangsyinfinite.httpsgithub.infinite.PianoSheetView.GENERATED_MUSIC_NOTES;

public class RecordedMusicNotes {
    private ArrayList<aNote> Notes = new ArrayList<aNote>();
    private ArrayList<aNote> ProcessedNotes = new ArrayList<aNote>();
    private int tempo = 60; //GENERATED_MUSIC_NOTES.getTempo();
    private int timeSignature_note = 4; //GENERATED_MUSIC_NOTES.getTimeSignature()[1];

    public RecordedMusicNotes() {}

    public String getAllNotes() {
        String list = "Notes: ";
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

    public double[][] getPianoSheetView(){
        double[][] convertedList = null;
        for (int i=0; i<Notes.size(); i++) {
            convertedList[i][0] = Notes.get(i).getNote();
            convertedList[i][1] = Notes.get(i).getNoteDuration();

        }
        return convertedList;
    }

    public void ProcessNote() {
        Notes.add(new aNote(0.0, 0));
        double curNote, curdB, endTime;
        double prepdB = Notes.get(0).getDbSPL();
        double prepNote = Notes.get(0).getNote();
        double startTime = Notes.get(0).getTimeStamp();
        for (int i=1; i<Notes.size(); i++) {
            curdB = Notes.get(i).getDbSPL();
            curNote = Notes.get(i).getNote();
            if (prepNote!=curNote) {
                endTime = Notes.get(i-1).getTimeStamp();
                double duration = endTime-startTime;
                int noteDuration = calculateNoteDuration(duration);
                if (noteDuration>0) {
                    aNote newNote = new aNote(prepNote, noteDuration);
                    newNote.setDbSPL(prepdB);
                    newNote.setTimeStamp(duration);
                    ProcessedNotes.add(newNote);
                }
                startTime = Notes.get(i).getTimeStamp();
            }
            if (prepNote==curNote && prepdB<curdB) {
                endTime = Notes.get(i-1).getTimeStamp();
                double duration = endTime-startTime;
                int noteDuration = calculateNoteDuration(duration);
                if (noteDuration>0) {
                    aNote newNote = new aNote(prepNote, noteDuration);
                    newNote.setDbSPL(prepdB);
                    newNote.setTimeStamp(duration);
                    ProcessedNotes.add(newNote);
                }
                startTime = Notes.get(i).getTimeStamp();
            }
            prepNote = curNote;
            prepdB = curdB;
        }
    }

    public int calculateNoteDuration (double duration) {
        double oneNoteDuration = 60 / tempo * timeSignature_note;
        double NotesDuration[] = new double[6];
        NotesDuration[0] = oneNoteDuration / 1.0; //one Whole note time
        NotesDuration[1] = oneNoteDuration / 2.0; //one Half note time
        NotesDuration[2] = oneNoteDuration / 4.0; //one Quarter note time
        NotesDuration[3] = oneNoteDuration / 8.0; //one Eighth note time
        NotesDuration[4] = oneNoteDuration / 16.0; //one 16th note time
        NotesDuration[5] = oneNoteDuration / 32.0; //one 32th note time
        if (duration>=NotesDuration[5] && duration<=NotesDuration[4]) {
            return 16;
        }
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
