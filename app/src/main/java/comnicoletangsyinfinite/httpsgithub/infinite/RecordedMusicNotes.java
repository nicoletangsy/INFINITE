package comnicoletangsyinfinite.httpsgithub.infinite;
//On Process: Store aNote instead of String

import java.util.ArrayList;

public class RecordedMusicNotes {
    ArrayList<aNote> Notes = new ArrayList<aNote>();

    public String getAllNotes() {
        String list = "";
        for (int i=0; i<Notes.size(); i++) {
            list = list + Notes.get(i).getNote() + " ";
        }
        return list;
    }

    public void addNotes (aNote aNote) {
        Notes.add(aNote);
    }
}
