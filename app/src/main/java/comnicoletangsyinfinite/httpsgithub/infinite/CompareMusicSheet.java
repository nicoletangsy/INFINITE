package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.Log;

import java.util.ArrayList;

public class CompareMusicSheet {
    ArrayList<ArrayList<Double>> generatedMusicSheet;
    ArrayList<ArrayList<Double>> recordedMusicNotes;

    public CompareMusicSheet() {
    }

    public void setGeneratedMusicSheet(ArrayList<ArrayList<Double>> generatedMusicSheet) {
        this.generatedMusicSheet = generatedMusicSheet;
    }

    public void setRecordedMusicNotes(ArrayList<ArrayList<Double>> recordedMusicNotes) {
        this.recordedMusicNotes = recordedMusicNotes;
    }

    public void compareTwoSheet() {
        for (int i = 0; i < generatedMusicSheet.size()-3; i++) {
            if (recordedMusicNotes.size() > i) {
                if (generatedMusicSheet.get(3 + i).get(0) != recordedMusicNotes.get(i).get(0)) {
                    generatedMusicSheet.get(3 + i).add((double) 1);
                }
            }else generatedMusicSheet.get(3 + i).add((double) 1);
        }

    }

    public ArrayList<ArrayList<Double>> getSheet() {
        return generatedMusicSheet;
    }
}
