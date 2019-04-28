package comnicoletangsyinfinite.httpsgithub.infinite;

import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;

public class CompareMusicSheet {
    ArrayList<ArrayList<Double>> generatedMusicSheet;
    ArrayList<ArrayList<Double>> recordedMusicSheet;
    ArrayList<ArrayList<Double>> userMusicSheet = new ArrayList<>();
    String Tag = "userMusicSheet";

    public CompareMusicSheet() {
    }

    public void setGeneratedMusicSheet(ArrayList<ArrayList<Double>> generatedMusicSheet) {
        this.generatedMusicSheet = generatedMusicSheet;
    }

    public void setRecordedMusicNotes(ArrayList<ArrayList<Double>> recordedMusicSheet) {
        this.recordedMusicSheet = recordedMusicSheet;
    }

    public void compareTwoSheet() {
        userMusicSheet.add(new ArrayList<Double>());
        userMusicSheet.get(0).add(generatedMusicSheet.get(0).get(0));
        userMusicSheet.get(0).add(generatedMusicSheet.get(0).get(1));
        userMusicSheet.add(new ArrayList<Double>());
        userMusicSheet.get(1).add(generatedMusicSheet.get(1).get(0));
        userMusicSheet.get(1).add(generatedMusicSheet.get(1).get(1));
        userMusicSheet.add(new ArrayList<Double>());
        userMusicSheet.get(2).add(generatedMusicSheet.get(2).get(0));
        userMusicSheet.get(2).add(generatedMusicSheet.get(2).get(1));

        for (int i = 0; i < generatedMusicSheet.size()-3; i++) {
            if (recordedMusicSheet.size() > i) {
                userMusicSheet.add(new ArrayList<Double>());
                userMusicSheet.get(i+3).add(recordedMusicSheet.get(i).get(0));
                userMusicSheet.get(i+3).add(recordedMusicSheet.get(i).get(1));
                if (Math.floor(generatedMusicSheet.get(3 + i).get(0)) != recordedMusicSheet.get(i).get(0)) {
                    userMusicSheet.get(i+3).add((double) 1);
                } else {
                    userMusicSheet.get(i+3).add((double) 0);
                }
            }
        }

    }

    public ArrayList<ArrayList<Double>> getSheet() {
        return userMusicSheet;
    }
}
