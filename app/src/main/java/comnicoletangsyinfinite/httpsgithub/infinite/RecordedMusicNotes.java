package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.Log;

import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_GENERATED_MUSIC_NOTES;
import java.util.ArrayList;


public class RecordedMusicNotes {
    private ArrayList<aNote> Notes = new ArrayList<aNote>();
    private ArrayList<aNote> ProcessedNotes = new ArrayList<aNote>();
    private ArrayList<ArrayList<Double>> pianoSheet = new ArrayList<>();

    private int tempo = 60; //GENERATED_MUSIC_NOTES.getTempo();
    private int timeSignature_note = 4; //GENERATED_MUSIC_NOTES.getTimeSignature()[1];

    public RecordedMusicNotes() {}

    //This getter is used for test & debug
    public String getAllNotes() {
        String list =""; /*= "Test: [" + calculateNoteDuration(0.25) + ", " + calculateNoteDuration(0.5) + ", " + calculateNoteDuration(1) + ", "
                + calculateNoteDuration(2) + ", " + calculateNoteDuration(4) + ", " + calculateNoteDuration(8) + ", "
                + calculateNoteDuration(0.26) + ", " + calculateNoteDuration(0.51) + ", " + calculateNoteDuration(1.01) + ", "
                + calculateNoteDuration(2.01) + ", " + calculateNoteDuration(4.01) + "]" ;
        list = list + "Notes: " + Notes.size()+ ", ";
        for (int i=0; i<Notes.size(); i++) {
            String dBSPL = String.format("%.1f", Notes.get(i).getDbSPL());
            String time = String.format("%.2f", Notes.get(i).getTimeStamp());
            list = list + "[" + Notes.get(i).getNote() + ", " + dBSPL + ", " + time + "] ";
        }*/
        list = list + "ProcessedNotes: ";
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

    //return user record as piano sheet
    public ArrayList<ArrayList<Double>> getPianoSheet(){
        for (int i=0; i<ProcessedNotes.size(); i++) {
            pianoSheet.add(new ArrayList<Double>());
            pianoSheet.get(i).add(ProcessedNotes.get(i).getNote());
            pianoSheet.get(i).add((double)ProcessedNotes.get(i).getNoteDuration());
        }
        return pianoSheet;
    }

    public void ProcessNote() {
        if (Notes.size()>0) {
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
                            ProcessedNotes.get(count).setTimeStamp(duration);
                            startTime = Notes.get(i).getTimeStamp();
                            prepNote = curNote;
                            prepdB = curdB;
                            aNote newNote = new aNote(prepNote, prepdB, startTime);
                            ProcessedNotes.add(newNote);
                            count++;
                        }
                    } else
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
                    } else {
                        prepdB = curdB;
                        prepNote = curNote;
                    }
                }
            }
            /*int last = A_GENERATED_MUSIC_NOTES.getPianoSheet().size()-1;
            Log.d("RecordedMusicNotes:",  "last = " + last);*/
            //(int)A_GENERATED_MUSIC_NOTES.getANoteDuration(last)
            ProcessedNotes.get(count).setNoteDuration(4);
        }
    }

    public int calculateNoteDuration (double duration) {
        double oneNoteDuration = 60 / tempo * timeSignature_note;
        double NotesDuration[] = new double[6];
        NotesDuration[0] = oneNoteDuration / 1.0; //one Whole note time
        NotesDuration[1] = oneNoteDuration / timeSignature_note * 3.0; //one Whole note time
        NotesDuration[2] = oneNoteDuration / 2.0; //one Half note time
        NotesDuration[3] = oneNoteDuration / 4.0; //one Quarter note time
        NotesDuration[4] = oneNoteDuration / 8.0; //one Eighth note time
        NotesDuration[5] = oneNoteDuration / 16.0; //one 16th note time
        if (duration>NotesDuration[5]) {
            if (duration<=NotesDuration[4]*1.2) {
                return 8;
            } else if (duration<=NotesDuration[3]*1.2) {
                return 4;
            } else if (duration<=NotesDuration[2]*1.2) {
                return 2;
            } else if (duration<=NotesDuration[1]*1.2) {
                return 3;
            } else if (duration<=NotesDuration[0]*1.2) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void removeAllRecords() {
        Notes.clear();
        ProcessedNotes.clear();
    }
}
