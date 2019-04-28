package comnicoletangsyinfinite.httpsgithub.infinite;

import android.util.Log;

import java.util.ArrayList;

public class CompareMusicSheet {
    ArrayList<ArrayList<Double>> generatedMusicSheet;
    ArrayList<ArrayList<Double>> recordedMusicSheet;
    ArrayList<ArrayList<Double>> userMusicSheet = new ArrayList<>();

    public CompareMusicSheet() {
    }

    public void setGeneratedMusicSheet(ArrayList<ArrayList<Double>> generatedMusicSheet) {
        this.generatedMusicSheet = generatedMusicSheet;
    }

    public void setRecordedMusicNotes(ArrayList<ArrayList<Double>> recordedMusicSheet) {
        this.recordedMusicSheet = recordedMusicSheet;
    }

    public void compareTwoSheet() {
        for (int i = 0; i < generatedMusicSheet.size()-3; i++) {
            if (recordedMusicSheet.size() > i) {
                userMusicSheet.add(new ArrayList<Double>());
                userMusicSheet.get(i).add(recordedMusicSheet.get(i).get(0));
                userMusicSheet.get(i).add(recordedMusicSheet.get(i).get(1));
                if (generatedMusicSheet.get(3 + i).get(0) != recordedMusicSheet.get(i).get(0)) {
                    userMusicSheet.get(i).add((double) 1);
                }
                else userMusicSheet.get(i).add((double) 0);
            }
        }

    }

    public ArrayList<ArrayList<Double>> getSheet() {
        return generatedMusicSheet;
    }
}
