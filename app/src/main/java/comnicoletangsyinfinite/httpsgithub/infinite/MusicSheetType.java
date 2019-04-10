package comnicoletangsyinfinite.httpsgithub.infinite;

public class MusicSheetType {
    private String sheetType;

    public MusicSheetType(){
        sheetType = "original";
    }

    public void changedToUserPlay(){
        sheetType = "userPlay";
    }

    public void changedToOriginal(){
        sheetType = "original";
    }

    public String getType(){
        return sheetType;
    }
}

