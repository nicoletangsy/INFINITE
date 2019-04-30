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

    //correct
//    public void compareTwoSheet() {
//        for (int i = 0; i < 3; i++) {
//            userMusicSheet.add(new ArrayList<Double>());
//            userMusicSheet.get(i).add(generatedMusicSheet.get(i).get(0));
//            userMusicSheet.get(i).add(generatedMusicSheet.get(i).get(1));
//        }
//        for (int i = 3; i < generatedMusicSheet.size(); i++) {
//            if(i!=17){
//            userMusicSheet.add(new ArrayList<Double>());
//            userMusicSheet.get(i).add(generatedMusicSheet.get(i).get(0));
//            userMusicSheet.get(i).add(generatedMusicSheet.get(i).get(1));
//            userMusicSheet.get(i).add((double)0);}
//            else{
//                userMusicSheet.add(new ArrayList<Double>());
//                userMusicSheet.get(i).add((double)52);
//                userMusicSheet.get(i).add((double)4);
//                userMusicSheet.get(i).add((double)1);}
//        }
//    }

    //wrong
//    public void compareTwoSheet2() {
//        hardCodeSheet = new ArrayList<ArrayList<Double>>();
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(0).add((double) 60);
//        hardCodeSheet.get(0).add((double) 4);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(1).add((double) 0);
//        hardCodeSheet.get(1).add((double) 0);
//        hardCodeSheet.get(1).add((double) 0);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(2).add((double) 1);
//        hardCodeSheet.get(2).add((double) 0);
//        hardCodeSheet.get(2).add((double) 0);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(3).add((double) 52);
//        hardCodeSheet.get(3).add((double) 8);
//        hardCodeSheet.get(3).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(4).add((double) 50);
//        hardCodeSheet.get(4).add((double) 8);
//        hardCodeSheet.get(4).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(5).add((double) 48);
//        hardCodeSheet.get(5).add((double) 8);
//        hardCodeSheet.get(5).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(6).add((double) 50);
//        hardCodeSheet.get(6).add((double) 8);
//        hardCodeSheet.get(6).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(7).add((double) 52);
//        hardCodeSheet.get(7).add((double) 8);
//        hardCodeSheet.get(7).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(8).add((double) 52);
//        hardCodeSheet.get(8).add((double) 8);
//        hardCodeSheet.get(8).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(9).add((double) 52);
//        hardCodeSheet.get(9).add((double) 4);
//        hardCodeSheet.get(9).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(10).add((double) 50);
//        hardCodeSheet.get(10).add((double) 8);
//        hardCodeSheet.get(10).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(11).add((double) 50);
//        hardCodeSheet.get(11).add((double) 8);
//        hardCodeSheet.get(11).add((double) 0);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(12).add((double) 50);
//        hardCodeSheet.get(12).add((double) 4);
//        hardCodeSheet.get(12).add((double) 0);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(13).add((double) 52);
//        hardCodeSheet.get(13).add((double) 8);
//        hardCodeSheet.get(13).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(14).add((double) 52);
//        hardCodeSheet.get(14).add((double) 8);
//        hardCodeSheet.get(14).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(15).add((double) 52);
//        hardCodeSheet.get(15).add((double) 4);
//        hardCodeSheet.get(15).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(16).add((double) 52);
//        hardCodeSheet.get(16).add((double) 8);
//        hardCodeSheet.get(16).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(17).add((double) 50);
//        hardCodeSheet.get(17).add((double) 8);
//        hardCodeSheet.get(17).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(18).add((double) 48);
//        hardCodeSheet.get(18).add((double) 8);
//        hardCodeSheet.get(18).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(19).add((double) 50);
//        hardCodeSheet.get(19).add((double) 8);
//        hardCodeSheet.get(19).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(20).add((double) 52);
//        hardCodeSheet.get(20).add((double) 8);
//        hardCodeSheet.get(20).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(21).add((double) 52);
//        hardCodeSheet.get(21).add((double) 8);
//        hardCodeSheet.get(21).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(22).add((double) 52);
//        hardCodeSheet.get(22).add((double) 4);
//        hardCodeSheet.get(2).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(23).add((double) 50);
//        hardCodeSheet.get(23).add((double) 8);
//        hardCodeSheet.get(23).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(24).add((double) 50);
//        hardCodeSheet.get(24).add((double) 8);
//        hardCodeSheet.get(24).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(25).add((double) 52);
//        hardCodeSheet.get(25).add((double) 8);
//        hardCodeSheet.get(25).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(26).add((double) 50);
//        hardCodeSheet.get(26).add((double) 8);
//        hardCodeSheet.get(26).add((double) 1);
//
//        hardCodeSheet.add(new ArrayList<Double>());
//        hardCodeSheet.get(27).add((double) 48);
//        hardCodeSheet.get(27).add((double) 4);
//        hardCodeSheet.get(27).add((double) 1);
//
//
//    }

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

        for (int i = 0; i < generatedMusicSheet.size() - 3; i++) {
            if (recordedMusicSheet.size() > i) {
                userMusicSheet.add(new ArrayList<Double>());
                userMusicSheet.get(i + 3).add(recordedMusicSheet.get(i).get(0));
                userMusicSheet.get(i + 3).add(recordedMusicSheet.get(i).get(1));
                if (Math.floor(generatedMusicSheet.get(3 + i).get(0)) != recordedMusicSheet.get(i).get(0)) {
                    userMusicSheet.get(i + 3).add((double) 1);
                } else {
                    userMusicSheet.get(i + 3).add((double) 0);
                }
            }
        }

    }

    public ArrayList<ArrayList<Double>> getSheet() {
        return userMusicSheet;

    }
}
