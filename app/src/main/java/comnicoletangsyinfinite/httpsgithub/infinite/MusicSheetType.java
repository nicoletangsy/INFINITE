package comnicoletangsyinfinite.httpsgithub.infinite;

public class MusicSheetType {
    private String sheetType;

    public MusicSheetType(){
        sheetType = "Reading";
    }

    public void changedToUserPlay(){
        sheetType = "Feedback";
    }

    public void changedToOriginal(){
        sheetType = "Reading";
    }

    public String getType(){
        return sheetType;
    }
}

