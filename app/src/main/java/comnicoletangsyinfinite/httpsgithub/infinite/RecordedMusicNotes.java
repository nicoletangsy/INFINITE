package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;

import static comnicoletangsyinfinite.httpsgithub.infinite.PianoSheetView.GENERATED_MUSIC_NOTES;

public class RecordedMusicNotes {
    private ArrayList<aNote> Notes = new ArrayList<aNote>();
    private ArrayList<aNote> ProcessedNotes = new ArrayList<aNote>();
    private int tempo = 60; //GENERATED_MUSIC_NOTES.getTempo();
    private int timeSignature_note = 4; //GENERATED_MUSIC_NOTES.getTimeSignature()[1];


    public String getAllNotes() {
        String list = "Notes: ";
        for (int i=0; i<Notes.size(); i++) {
            String dBSPL = String.format("%.1f", Notes.get(i).getDbSPL());
            list = list + "[" + Notes.get(i).getNote() + ", " + dBSPL + "] ";
        }
        list = list + "\n ProcessedNotes: ";
        for (int i=0; i<ProcessedNotes.size(); i++) {
            String dBSPL = String.format("%.1f", ProcessedNotes.get(i).getDbSPL());
            list = list + "[" + ProcessedNotes.get(i).getNote() + ", " + ProcessedNotes.get(i).getNoteDuration() + ", " + dBSPL + "] ";
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
        double curNote, curdB;
        double prepdB = Notes.get(0).getDbSPL();
        double prepNote = Notes.get(0).getNote();
        double startTime = Notes.get(0).getTimeStamp();
        double endTime = -1;
        for (int i=1; i<Notes.size(); i++) {
            curdB = Notes.get(i).getDbSPL();
            curNote = Notes.get(i).getNote();
            if (prepNote!=curNote) {
                endTime = Notes.get(i-1).getTimeStamp();
                aNote newNote = new aNote(prepNote, calculateNoteDuration(startTime, endTime));
                newNote.setDbSPL(curdB);
                ProcessedNotes.add(newNote);
                if (i!=(Notes.size()-1)) {
                    prepNote = curNote;
                    prepdB = curdB;
                    startTime = Notes.get(i).getTimeStamp();
                }
            }
            if (prepNote==curNote && prepdB<curdB) {
                endTime = Notes.get(i).getTimeStamp();
                aNote newNote = new aNote(prepNote, calculateNoteDuration(startTime, endTime));
                newNote.setDbSPL(curdB);
                ProcessedNotes.add(newNote);
                if (i!=(Notes.size()-1)) {
                    prepNote = curNote;
                    prepdB = curdB;
                    startTime = Notes.get(i).getTimeStamp();
                }
            }
        }
    }

    public int calculateNoteDuration (double startTime, double endTime) {
        double duration = endTime - startTime;
        double oneNoteDuration = tempo / 60;
        if (duration<oneNoteDuration*timeSignature_note/32) {
            return 32;
        } else if (duration<=oneNoteDuration*timeSignature_note/16) {
            return 16;
        } else if (duration<=oneNoteDuration*timeSignature_note/8) {
            return 8;
        } else if (duration<=oneNoteDuration*timeSignature_note/4) {
            return 4;
        } else if (duration<=oneNoteDuration*timeSignature_note/2) {
            return 2;
        } else {
            return 1;
        }
    }
}
