package comnicoletangsyinfinite.httpsgithub.infinite;
//On Process: Store aNote instead of String

import java.util.ArrayList;

public class RecordedMusicNotes {
    ArrayList<String> Notes = new ArrayList<String>();

    public String getList() {
        String list = "";
        for (int i=0; i<Notes.size(); i++) {
            list = list + Notes.get(i) + " ";
        }
        return list;
    }

    public void addNotes (String aNote) {
        Notes.add(aNote);
    }
}
