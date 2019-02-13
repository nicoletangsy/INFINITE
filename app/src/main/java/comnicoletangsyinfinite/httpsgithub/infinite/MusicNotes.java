package comnicoletangsyinfinite.httpsgithub.infinite;

import java.util.ArrayList;

public class MusicNotes {
    ArrayList<String> Notes = new ArrayList<String>();

    public String getList() {
        String list = "";
        for (int i=0; i<Notes.size(); i++) {
            list = list + Notes.get(i);
        }
        return list;
    }

    public void addNotes (String aNote) {
        Notes.add(aNote);
    }
}
